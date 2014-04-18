/*
 * This file is part of The Technic Launcher Version 3.
 * Copyright (C) 2013 Syndicate, LLC
 *
 * The Technic Launcher is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Technic Launcher  is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License,
 * as well as a copy of the GNU Lesser General Public License,
 * along with The Technic Launcher.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.technicpack.launcher.ui.controls;

import com.sun.awt.AWTUtilities;
import net.technicpack.launcher.ui.controls.borders.DropShadowBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class LauncherDialog extends JDialog {
    private int dragGripX;
    private int dragGripY;

    public LauncherDialog(Frame owner) {
        super(owner, null, true);

        setUndecorated(true);
        getRootPane().setBorder(new DropShadowBorder(Color.black, 4));
        AWTUtilities.setWindowOpaque(this, false);
        ((JPanel)getContentPane()).setOpaque(true);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        centerOnParent();
    }

    @Override
    public void setSize(Dimension d) {
        super.setSize(d);
        centerOnParent();
    }

    private void centerOnParent() {
        Window frame = getOwner();

        if (frame == null)
            return;

        int parentCenterX = frame.getX() + (frame.getWidth()/2);
        int parentCenterY = frame.getY() + (frame.getHeight()/2);

        this.setBounds(parentCenterX - (getWidth()/2), parentCenterY - (getHeight()/2), getWidth(), getHeight());
    }
}
