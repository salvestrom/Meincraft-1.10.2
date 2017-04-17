// Date: 12/07/2014 00:30:08
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package com.salvestrom.w2theJungle.mobs.models;

import java.util.Random;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

public class ModelClobberer extends ModelBase
{
    //claws
    public ModelRenderer forearmR;	public ModelRenderer upperRarm;
    public ModelRenderer clawRmain;
    public ModelRenderer clawRmainsub;
    public ModelRenderer clawRsub;	public ModelRenderer clawRsub2;

    private float rads = 180F/(float)Math.PI;
	private Random rng = new Random();
  
  public ModelClobberer()
  {
    textureWidth = 128;
    textureHeight = 128;
    
//TODO readjust all rot points to have claw main as adult, allowing for better animation of claw.
      upperRarm = new ModelRenderer(this, 16, 46);
      upperRarm.addBox(-0F, -2F, -2F, 6, 4, 4); //-6 -2 -2
      upperRarm.setRotationPoint(-9F, 0F, 0); //-8 12.5 -3 :: -8 2.5 -4
      upperRarm.setTextureSize(128, 128);
      upperRarm.mirror = true;
      setRotation(upperRarm, 0F, -0.5235988F, 0F);
      forearmR = new ModelRenderer(this, 8, 55);
      forearmR.addBox(0F, -2.5F, -2.5F, 9, 5, 5); //-9
      forearmR.setRotationPoint(0F, -0F, -0F); //-12 12 -6 :: -5
      forearmR.setTextureSize(128, 128);
      forearmR.mirror = true;
      setRotation(forearmR, 0F, -(0.8726646F-0.5235988F), 0F); //0.3490659F
      clawRmain = new ModelRenderer(this, 0, 66);
      clawRmain.addBox(-8F, -3F, -3F, 8, 6, 6);
      clawRmain.setRotationPoint(-0f, 0f, 0f); //(-6.3F, 0F, 0.65F); //-16.96, 12.42667, -10
      clawRmain.setTextureSize(128, 128);
      setRotation(clawRmain, 0F, -1.22173F+0.8726646F, 0F);
      clawRmainsub = new ModelRenderer(this, 0, 23);
      clawRmainsub.mirror = true;
      clawRmainsub.addBox(-9F, -2.5F, -2.5F, 9, 5, 5);
      clawRmainsub.setRotationPoint(8, 0, 0); //(-5.4F, 0F, 0.65F); //-19.96F, 12.04F, -15 : 
      clawRmainsub.setTextureSize(128, 128);
      clawRmainsub.mirror = true;
      setRotation(clawRmainsub, 0F, -1.570796F+1.22173F, 0F);
      clawRsub = new ModelRenderer(this, 10, 79);
      //clawRsub.mirror = true;
      clawRsub.addBox(-6F, -2F, -1.5F, 6, 4, 3);
      clawRsub.setRotationPoint(-6.4F, 0F, -1.6F); //-15.96F, 12.52F, -11F
      clawRsub.setTextureSize(128, 128);
      clawRsub.mirror = true;
      setRotation(clawRsub, 0F, -60/rads, 0F);
      clawRsub2 = new ModelRenderer(this, 0, 35);
      //clawRsub2.mirror = true;
      clawRsub2.addBox(-5F, -1.5F, -1.5F, 5, 3, 3);
      clawRsub2.setRotationPoint(-4.9F, 0F, 0F); //-14.57333F, 12.97333F, -16F
      clawRsub2.setTextureSize(128, 128);
      clawRsub2.mirror = true;
      setRotation(clawRsub2, 0F, 20/rads, 0F);

      this.forearmR.addChild(upperRarm);
      this.clawRmain.addChild(clawRmainsub);
      this.clawRmain.addChild(forearmR);
      this.clawRmain.addChild(clawRsub); this.clawRsub.addChild(clawRsub2);
      
      }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, ItemCameraTransforms.TransformType type)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity, type);
    clawRmain.render(f5);
   }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  int counter;
  public void setRotationAngles(float time, float motion, float age, float f3, float f4, float f5, Entity ntt, ItemCameraTransforms.TransformType type) {
	  
	  super.setRotationAngles(time, motion, age, f3, f4, f5, ntt);
	  
	  this.upperRarm.setRotationPoint(8, 0, 0);
		this.forearmR.setRotationPoint(-2.7f, 0, -0.25f);
		this.clawRmain.setRotationPoint(-11, 2.5f, -15);
		this.clawRmainsub.setRotationPoint(-5.5F, 0, 0.5F);
		this.clawRsub.setRotationPoint(-1.37f, 0.0f, -1.675f);
		
		this.clawRmain.rotateAngleX = 1f/rads;
		this.clawRmain.rotateAngleZ = -2f/rads;
		this.clawRmain.rotateAngleY = -48/rads;
	  
		counter++;

		switch(type) {
		case THIRD_PERSON_RIGHT_HAND:
			
			this.upperRarm.rotateAngleY = +0.5235988F - 56/rads + (float) (MathHelper.sin((float) (counter)/100) * 0.085F);
			this.forearmR.rotateAngleY = (0.8726646F-0.5235988F)-38/rads + (float) (MathHelper.sin((float) (counter)/100) * 0.085F);
			this.clawRsub.rotateAngleY = (float) (MathHelper.sin((float) (counter)/100) * 0.25F) - 60/rads + 8/rads;
			break;
		case GROUND:
			this.upperRarm.rotateAngleY = 0.5235988F;
			this.forearmR.rotateAngleY = -(0.8726646F-0.5235988F)+38/rads;
			this.clawRsub.rotateAngleY = - 60/rads;
			break;
		case FIRST_PERSON_RIGHT_HAND:
			this.upperRarm.rotateAngleY = +0.5235988F - 56/rads + (float) (MathHelper.sin((float) (counter)/100) * 0.085F);
			this.forearmR.rotateAngleY = (0.8726646F-0.5235988F)-38/rads + (float) (MathHelper.sin((float) (counter)/100) * 0.085F);
			this.clawRsub.rotateAngleY = (float) (MathHelper.sin((float) (counter)/100) * 0.25F) - 60/rads + 8/rads;
			break;
		case GUI:
			this.upperRarm.rotateAngleY = 0.5235988F;
			this.forearmR.rotateAngleY = -(0.8726646F-0.5235988F)+38/rads;
			this.clawRsub.rotateAngleY = - 60/rads;

			break;
		default:
			break;
			
		}
	  
	  //age++;
	 //	  this.clawRsub.rotateAngleY = (float) (MathHelper.sin((float)time*0.7F)-60/rads);
	  	  
	  //System.out.println(counter);

	  
	  if(motion > 0) {
		  
//	  	  EntitySwampCrab crab = (EntitySwampCrab)ntt;
//	  	  int clawSnaps = crab.getClawSnap();
	  	  float range = 0.02F; //of movement
	  	  
	  //	  this.upperRarm.rotateAngleY = (float) (MathHelper.sin((float) (age / 2/Math.PI)) * range)-0.5235988F+motion;
	  	  //if(this.)
	 // 	  this.forearmR.rotateAngleY = (float) (MathHelper.sin((float) (-1F + (age / 2/Math.PI))) * range)-20/rads;
	 // 	  this.clawRmain.rotateAngleY = (float) (MathHelper.sin((float) (-1.6F + (age / 2/Math.PI))) * range)-20/rads;
	  	  
	  	 // if (clawSnaps < 15) {
	  		  range = 0.3F;
	  		//  this.clawRsub.rotateAngleY = (float) (MathHelper.sin((float) (-0.85F-(age / 2/Math.PI))*3F) * range)-60/rads;
	  	 // } else {
	  	//	  this.clawRsub.rotateAngleY = (float) (MathHelper.sin((float) (-2.2F + (age / 2/Math.PI))) * range)-60/rads;
	  	 // }
	  }
  }
  
  public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float time, float speed, float par4) {
	  
	  
	  
	  
	}
  
  //use this elsewhere
  public float legAnimation(float waveOffset, float time) {
	  
	  float r = 0.7F; //frequency modifier (swing speed)
	  float w = waveOffset;
	  return (0.75F * MathHelper.sin(w + time * r)); //0.5
  }
/*
public void setLivingAnimations(Entity entity, float time, float speed, float par4) {
	
	counter++;
	if(counter > 359) {counter = 0;}

	this.clawRsub.rotateAngleY = (float) (MathHelper.sin((float) (-0.85F-(counter / 180/Math.PI))*29.73F) * 0.13F)-60/rads;
	
}
*/
}
