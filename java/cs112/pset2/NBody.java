/*
 *This program will create a virtual setting with a given radius and simulate the movement of planets around the sun as well as
 *account for the gravitational laws involved with the planets.
 *
 */

class NBody
{
   public static void main(String[] args)
   {
         PennDraw.enableAnimation(30);
         double simulationTime = Double.parseDouble(args[0]);
         double timeStep = Double.parseDouble(args[1]);
         String filename = args[2];
         In reader = new In("nbody_data/" + filename);
         int numParticles = reader.readInt();
         double radius = reader.readDouble();
         double[] mass, px, py, vx, vy;
         mass = new double[numParticles];
         px = new double[numParticles];
         py = new double[numParticles];
         vx = new double[numParticles];
         vy = new double[numParticles];
         String[] img = new String[numParticles];
         for (int i = 0; i < numParticles; i++)
         {
            mass[i] = reader.readDouble();
            px[i] = reader.readDouble();
            py[i] = reader.readDouble();
            vx[i] = reader.readDouble();
            vy[i] = reader.readDouble();
            img[i] = reader.readString();
         }
         for(double runTime = 0.0; runTime <= simulationTime; runTime+=timeStep)
         {
               PennDraw.setXscale(-radius,radius);
               PennDraw.setYscale(-radius,radius);
               PennDraw.picture(0,0, "nbody_data/starfield.jpg");
               double netForce = 0.0;
               double forceX = 0.0;
               double forceY = 0.0;
               double changeX = 0.0;
               double changeY = 0.0;
               double distance = 0.0;
               double accelerationX = 0.0;
               double accelerationY = 0.0;
               double gravity = .0000000000667;
               for (int a = 0; a < numParticles; a++)
               //This for loop representing planet a and the total force exerted on a by every other planets, but planet a will NOT be the sun
               {
                     if (img[a].equals("sun.gif")) continue;
                     for (int b = 0; b < numParticles; b++)
                     //updates and calculates the velocity of planet a with the current planet b 
                     {
                        if (a == b) continue;
                        changeX = px[b] - px[a];
                        changeY = py[b] - py[a];
                        distance = Math.sqrt((Math.pow(changeX, 2) + Math.pow(changeY, 2)));
                        netForce = ((gravity * mass[a] * mass[b]) / (distance * distance));
                        forceX = netForce * (changeX / distance);
                        forceY = netForce * (changeY / distance);
                        accelerationX = forceX / mass[a];
                        accelerationY = forceY / mass[a];
                        vx[a] += (timeStep * accelerationX);
                        vy[a] += (timeStep * accelerationY);
                     }
               }
               for (int h = 0; h < numParticles; h++)
               //This is to change the position of the planets based on the new velocities
               {
                     px[h] += (timeStep * vx[h]);
                     py[h] += (timeStep * vy[h]);
               }
               for (int k = 0; k < numParticles; k++)
               //This draws the images in the correct positions for the current iteration 
               {
                   PennDraw.picture(px[k], py[k], "nbody_data/" + img[k]);
               }

               PennDraw.advance();
               //advance resets the values for the next iteration and progress the animation
         }
         System.out.printf("%d\n", numParticles);
         System.out.printf("%.2e\n", radius);
         for (int i = 0; i < numParticles; i++) 
         {
            System.out.printf("%12.5e %12.5e %12.5e %12.5e %12.5e %12s\n", mass[i], px[i], py[i], vx[i], vy[i], img[i]);
         }
   }
   
}