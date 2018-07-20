/**
 * Licensed to JumpMind Inc under one or more contributor
 * license agreements.  See the NOTICE file distributed
 * with this work for additional information regarding
 * copyright ownership.  JumpMind Inc licenses this file
 * to you under the GNU General Public License, version 3.0 (GPLv3)
 * (the "License"); you may not use this file except in compliance
 * with the License.
 *
 * You should have received a copy of the GNU General Public License,
 * version 3.0 (GPLv3) along with this library; if not, see
 * <http://www.gnu.org/licenses/>.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jumpmind.metl.ui.views.design.menu;

import org.apache.commons.lang.ArrayUtils;
import org.jumpmind.metl.ui.common.CutCopyPasteManager;
import org.jumpmind.metl.ui.i18n.MessageResource;
import org.jumpmind.metl.ui.views.design.DesignNavigator;

public class ResourceMenuManager extends AbstractDesignSelectedValueMenuManager {

    public ResourceMenuManager(DesignNavigator navigator) {
        super(navigator);
    }
    
    @Override
    public boolean handle(String menuSelected, Object selected) {
        if (!super.handle(menuSelected, selected)) {            
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    protected String[] getDisabledPaths(Object selected) {
        if (isReadOnly(selected)) {
            return (String[])ArrayUtils.addAll(super.getDisabledPaths(selected), new String[] { MessageResource.getEditRemove()
            });            
        } else {
            return super.getDisabledPaths(selected);
        }
    }
    
    @Override
    protected String[] getEnabledPaths(Object selected) {
        String[] enabledPaths = (String[]) ArrayUtils.addAll(super.getEnabledPaths(selected), new String[] {
        		MessageResource.getNewDependency(),
        		MessageResource.getNewDesign(),
        		MessageResource.getNewTest(),
        		MessageResource.getNewHierarchical(),
                MessageResource.getNewRelational(),
                MessageResource.getNewDatabase(),
                MessageResource.getNewFTP(),
                MessageResource.getNewFileSystem(),
                MessageResource.getNewJMS(),
                MessageResource.getNewSFTP(),
                MessageResource.getNewSMB(),
                MessageResource.getNewHTTP(),
                MessageResource.getNewMailSession(),
                MessageResource.getNewSubscribeJMS(),
                MessageResource.getFileOpen(),
                MessageResource.getFileImport(),        
                MessageResource.getFileExport(),                
                MessageResource.getEditRename(),
                MessageResource.getEditCut(),
                MessageResource.getEditCopy(),                
                MessageResource.getEditRemove()
        });
        if (navigator.getContext().getClipboard()
                .containsKey(CutCopyPasteManager.CLIPBOARD_OBJECT_TYPE)) {
            enabledPaths = (String[]) ArrayUtils.add(enabledPaths, MessageResource.getEditPaste());
        }
        return enabledPaths;         
    }
}
