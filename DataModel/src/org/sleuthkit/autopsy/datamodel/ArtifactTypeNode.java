/*
 * Autopsy Forensic Browser
 * 
 * Copyright 2011 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.datamodel;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Sheet;
import org.openide.util.lookup.Lookups;
import org.sleuthkit.datamodel.BlackboardArtifact;
import org.sleuthkit.datamodel.BlackboardArtifact.ARTIFACT_TYPE;
import org.sleuthkit.datamodel.SleuthkitCase;
import org.sleuthkit.datamodel.TskException;

/**
 *
 * @author dfickling
 */
public class ArtifactTypeNode extends AbstractNode implements DisplayableItemNode{
    
    int childCount = 0;

    ArtifactTypeNode(ARTIFACT_TYPE t, SleuthkitCase skCase) {
        super(Children.create(new ArtifactTypeChildren(t, skCase), true));
        super.setName(t.getLabel());
        // NOTE: This completely destroys our lazy-loading ideal
        //    a performance increase might be had by adding a 
        //    "getBlackboardArtifactCount()" method to skCase
        try {
            this.childCount = skCase.getBlackboardArtifacts(t.getTypeID()).size();
        } catch (TskException ex) {
            Logger.getLogger(ArtifactTypeNode.class.getName())
                    .log(Level.INFO, "Error getting child count", ex);
        }
        super.setDisplayName(t.getDisplayName() + " (" + childCount + ")");
        this.artifactType = t;
        this.setIconBaseWithExtension("org/sleuthkit/autopsy/images/artifact-icon.png");
        
    }
    
    @Override
    protected Sheet createSheet() {
        Sheet s = super.createSheet();
        Sheet.Set ss = s.get(Sheet.PROPERTIES);
        if (ss == null) {
            ss = Sheet.createPropertiesSet();
            s.put(ss);
        }
        
        ss.put(new NodeProperty("Artifact Type",
                                "Artifact Type",
                                "no description",
                                artifactType.getDisplayName()));
        
        ss.put(new NodeProperty("Child Count",
                                "Child Count",
                                "no description",
                                childCount));

        return s;
    }

    @Override
    public <T> T accept(DisplayableItemNodeVisitor<T> v) {
        return v.visit(this);
    }
}