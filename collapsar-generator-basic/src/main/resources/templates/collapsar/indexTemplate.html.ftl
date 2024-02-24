﻿<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <meta name="Author" contect="${author}">
  <title>${title}</title>
  <meta name="Description" contect="${description}">
<link rel="stylesheet" href="./style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<script id="2d-fragment-shader" type="x-shader/x-fragment">// <![CDATA[

// Look below at line 23 for realism.

#ifdef GL_ES
precision mediump float;
#endif

#define PI 3.14159265359

uniform sampler2D u_image;
varying vec2 v_texCoord;

uniform vec2 u_resolution;
uniform vec2 u_mouse;
uniform float u_mass;
uniform float u_time;
uniform float u_clickedTime;

vec2 rotate(vec2 mt, vec2 st, float angle){
	float cos = cos((angle + u_clickedTime) * PI); // try replacing * 1.0 with * PI
	float sin = sin(angle * 0.0); // try removing the * 0.0
	
	// Uncomment these two lines for realism
	//float cos = cos(angle) * (u_time * 0.3);
	//float sin = sin(angle) * (u_time * 0.3);
	
	float nx = (cos * (st.x - mt.x)) + (sin * (st.y - mt.y)) + mt.x;
	float ny = (cos * (st.y - mt.y)) - (sin * (st.x - mt.x)) + mt.y;
	return vec2(nx, ny);
}

void main() {
     vec2 st = vec2(gl_FragCoord.x, u_resolution.y - gl_FragCoord.y)/u_resolution;
	vec2 mt = vec2(u_mouse.x, u_resolution.y - u_mouse.y)/u_resolution;

	float dx = st.x - mt.x;
	float dy = st.y - mt.y;

	float dist = sqrt(dx * dx + dy * dy);
	float pull = u_mass / (dist * dist);
	
     vec3 color = vec3(0.0);
	
	vec2 r = rotate(mt,st,pull);
	vec4 imgcolor = texture2D(u_image, r);
	color = vec3(
		(imgcolor.x - (pull * 0.25)),
		(imgcolor.y - (pull * 0.25)), 
		(imgcolor.z - (pull * 0.25))
	);
	

     gl_FragColor = vec4(color,1.);
}
// ]]></script>
<script id="2d-vertex-shader" type="x-shader/x-vertex">// <![CDATA[
	attribute vec2 a_position;
	attribute vec2 a_texCoord;
	
	varying vec2 v_texCoord;
	void main() {
		gl_Position = vec4(a_position, 0, 1);
		v_texCoord = a_texCoord;
	}
	// ]]></script>
<div id="cover">
  <p>作者: ${author}</p>
  <p>标题: ${title}</p>
  <p>描述 ${description}</p>
</div>
<canvas id="glscreen"></canvas>
<!-- partial -->
  <script src='jquery.min.js'></script><script  src="./script.js"></script>

</body>
</html>
