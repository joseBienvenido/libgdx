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

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class LagTest extends Activity implements Renderer
{
	public void onCreate( Bundle bundle )
	{
		super.onCreate( bundle );
		requestWindowFeature(Window.FEATURE_NO_TITLE);        
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
		GLSurfaceView view = new GLSurfaceView( this );
		view.setRenderer( this );
		setContentView( view );
	}

	long startTime = 0;
	int frames;
	
	@Override
	public void onDrawFrame(GL10 gl) 
	{
		frames++;
		if( System.nanoTime() - startTime > 1000000000 )
		{
			Log.d( "Lag Test", "fps: " + frames );
			startTime = System.nanoTime();
			frames = 0;
		}
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) 
	{	
		startTime = System.nanoTime();
		frames = 0;
	}
}
