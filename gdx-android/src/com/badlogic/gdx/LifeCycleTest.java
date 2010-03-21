/*
 *  This file is part of Libgdx by Mario Zechner (badlogicgames@gmail.com)
 *
 *  Libgdx is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Libgdx is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with libgdx.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.badlogic.gdx;

import com.badlogic.gdx.backends.android.AndroidApplication;

import android.os.Bundle;

public class LifeCycleTest extends AndroidApplication
{
	public void onCreate( Bundle bundle )
	{
		super.onCreate( bundle );
		this.initialize(false);
		com.badlogic.gdx.tests.LifeCycleTest test = new com.badlogic.gdx.tests.LifeCycleTest();
		this.setApplicationListener( test );
		this.getGraphics().setRenderListener( test );
	}
}
