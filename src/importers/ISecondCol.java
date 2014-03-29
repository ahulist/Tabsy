/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package importers;

import java.io.File;

/**
 *
 * @author Aleksander Hulist <aleksander.hulist@gmail.com>
 */
public interface ISecondCol extends IImporter{
    public void _import(File f);
}
