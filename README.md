Hikers
======

Data Structures Hiker Project

Project Overview (minimum requirements)
=======================================

The Purple Mountain National Forest has four (4) different hiking trail entrance entrances. 
Hiking on these trail can be dangerous.  So, the Forest officials have decided to use a computer 
program to help them keep track of hikers and let the hikers in and out of the mountain in an organized way. 

The program should keep track of hikers who assemble at each entrance by 7:00 AM.
Let hikers from each entrance go up the mountain in groups of 20 and one group at a time. 

You are asked to write this program. The program creates hikers and adds each hiker to different trail entrance at random. 
The hikers are added to the current stack in the trail entrance being formed. 
Each trail entrance can have multiple stacks depending on how many hikers arrive at any specific trail entrance. 

As soon as a stack in a trail entrance becomes full (has 10 hikers in it), the stack is placed in a queue. 

At 7:00AM, the forest attendant, who uses this program, will start letting hikers up the mountain from the queue. 
No hiker can go up the mountain after 10:00 AM, but some trials may have half-full stacks. 
Therefore, your program should allow the attendant to check the trail entrances in the order and let the
hikers in half-full stacks in.

Upon arrival (creation of a hiker), his/her information will be registered (written in a file).
Hikers will be named as: hiker#, where # is a number, which is incremented by one each time a hiker is created.


You may need to use other data structures to keep track of trail entrances’ status as well. 

Your program should have a very simple GUI with 3 buttons and a text area. 
	Start: will start the program by creating hikers, registering them (writing their information on a file), placing them in stacks and adding the filled stacks in the queue.
	Open Trail entrances: will take the stacks out of the queue (let the hikers in) and print the hikers’ names on the text area
	Check Trail entrance: will check the trail entrances (1 to 4) to see if there is any stack of hikers that is not full. If so, let the hikers in that stack up the mountain and print the hikers’ names on the text area.

Completed Project Overview
==========================

------------------------------------Details of our own creation go below-------------------------------------------------------
