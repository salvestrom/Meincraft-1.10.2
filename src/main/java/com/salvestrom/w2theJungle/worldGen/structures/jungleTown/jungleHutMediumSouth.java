/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package com.salvestrom.w2theJungle.worldGen.structures.jungleTown;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.salvestrom.w2theJungle.init.JungleBlocks;
import com.salvestrom.w2theJungle.worldGen.loot_tables.JungleLootTableRegistry;
import com.salvestrom.w2theJungle.worldGen.structures.blockPlacmentBridge;

//south as in door faces south


public class jungleHutMediumSouth extends WorldGenerator
{
	public blockPlacmentBridge bridge = new blockPlacmentBridge();

	public ResourceLocation fillchest = JungleLootTableRegistry.JUNGLE_CHESTS_HUT;

	protected Block[] GetValidSpawnBlocks() {
		return new Block[] {
			Blocks.GRASS,
			Blocks.STONE,
			Blocks.DIRT,
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k)
	{
		int distanceToAir = 0;
		
		BlockPos pos = new BlockPos(i, j, k);
		Block checkID = world.getBlockState(pos).getBlock();

		if(checkID != Blocks.AIR)
		{
			distanceToAir++;
			checkID = world.getBlockState(pos.add(0, distanceToAir, 0)).getBlock();
		}

		if (distanceToAir > 5){
			return false;
		}
		j += distanceToAir-1; 

		Block blockID = world.getBlockState(pos).getBlock();
		Block blockIDAbove = world.getBlockState(pos.up()).getBlock();
		Block blockIDBelow = world.getBlockState(pos.down()).getBlock();
		for (Block x : GetValidSpawnBlocks()){
			if (blockIDAbove != Blocks.AIR)
			{
				return false;
			}
			if (blockID == x){
				return true;
			}else if (blockID == Blocks.SNOW && blockIDBelow == x){
				return true;
			}
		}
		return false;
	}

	public jungleHutMediumSouth() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 8, j, k) || !LocationIsValidSpawn(world, i + 8, j, k - 6) || !LocationIsValidSpawn(world, i, j, k - 6))
		{
			return false;
		}

		bridge.setBlock(world, i + 0, j + 0, k - 0, Blocks.DIRT);
		bridge.setBlock(world, i + 0, j + 0, k - 1, Blocks.DIRT);
		bridge.setBlock(world, i + 0, j + 0, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 0, j + 0, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 0, j + 0, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 0, j + 0, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 0, j + 0, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 0, j + 1, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 1, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 1, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 1, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 1, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 0, j + 1, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 2, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 2, k - 1, JungleBlocks.mossystairs, 3, 2);
		bridge.setBlock(world, i + 0, j + 2, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 2, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 2, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 2, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 2, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 3, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 3, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 3, k - 2, JungleBlocks.mossystairs, 3, 2);
		bridge.setBlock(world, i + 0, j + 3, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 3, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 3, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 3, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 4, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 4, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 4, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 4, k - 3, JungleBlocks.mossystairs, 3, 2);
		bridge.setBlock(world, i + 0, j + 4, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 4, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 4, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 5, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 5, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 5, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 5, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 5, k - 4, JungleBlocks.mossyslabSingle, 1, 2);
		bridge.setBlock(world, i + 0, j + 5, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 5, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 6, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 6, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 6, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 6, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 6, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 6, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 6, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 7, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 7, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 7, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 7, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 7, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 7, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 0, j + 7, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 0, k - 0, Blocks.DIRT);
		bridge.setBlock(world, i + 1, j + 0, k - 1, Blocks.DIRT);
		bridge.setBlock(world, i + 1, j + 0, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 1, j + 0, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 1, j + 0, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 1, j + 0, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 1, j + 0, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 1, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 1, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 1, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 1, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 1, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 2, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 2, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 2, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 2, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 2, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 2, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 3, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 3, k - 1, Blocks.COBBLESTONE_WALL, 1, 2);
		bridge.setBlock(world, i + 1, j + 3, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 3, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 3, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 3, k - 5, Blocks.COBBLESTONE_WALL, 1, 2);
		bridge.setBlock(world, i + 1, j + 3, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 4, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 4, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 4, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 4, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 4, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 4, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 4, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 5, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 5, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 5, k - 2, JungleBlocks.mossystairs, 4, 2);
		bridge.setBlock(world, i + 1, j + 5, k - 3, JungleBlocks.mossystairs, 4, 2);
		bridge.setBlock(world, i + 1, j + 5, k - 4, Blocks.STONE_STAIRS, 4, 2);
		bridge.setBlock(world, i + 1, j + 5, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 5, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 6, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 6, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 6, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 6, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 6, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 6, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 6, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 7, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 7, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 7, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 7, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 7, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 7, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 1, j + 7, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 0, k - 0, Blocks.DIRT);
		bridge.setBlock(world, i + 2, j + 0, k - 1, Blocks.DIRT);
		bridge.setBlock(world, i + 2, j + 0, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 2, j + 0, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 2, j + 0, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 2, j + 0, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 2, j + 0, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 2, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 2, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 1, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 1, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 1, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 1, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 2, j + 2, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 2, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 2, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 2, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 2, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 2, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 3, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 3, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 2, j + 3, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 3, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 3, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 3, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 2, j + 3, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 4, k - 0, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 2, j + 4, k - 1, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 2, j + 4, k - 2, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 2, j + 4, k - 3, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 2, j + 4, k - 4, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 2, j + 4, k - 5, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 2, j + 4, k - 6, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 2, j + 5, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 5, k - 1, JungleBlocks.mossystairs, 7, 2);
		bridge.setBlock(world, i + 2, j + 5, k - 2, Blocks.GRASS);
		bridge.setBlock(world, i + 2, j + 5, k - 3, Blocks.GRASS);
		bridge.setBlock(world, i + 2, j + 5, k - 4, Blocks.GRASS);
		bridge.setBlock(world, i + 2, j + 5, k - 5, JungleBlocks.mossystairs, 6, 2);
		bridge.setBlock(world, i + 2, j + 5, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 6, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 6, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 6, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 6, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 6, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 6, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 6, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 7, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 7, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 7, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 7, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 7, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 7, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 2, j + 7, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 0, k - 0, Blocks.DIRT);
		bridge.setBlock(world, i + 3, j + 0, k - 1, Blocks.DIRT);
		bridge.setBlock(world, i + 3, j + 0, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 3, j + 0, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 3, j + 0, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 3, j + 0, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 3, j + 0, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 3, j + 1, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 1, k - 2, JungleBlocks.mossyslabSingle, 3, 2);
		bridge.setBlock(world, i + 3, j + 1, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 1, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 1, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 3, j + 2, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 2, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 2, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 2, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 2, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 2, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 3, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 3, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 3, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 3, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 3, k - 5, JungleBlocks.mossyStoneSteps, 2, 2);
		bridge.setBlock(world, i + 3, j + 3, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 4, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 4, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 4, k - 2, Blocks.LOG, 7, 2);
		bridge.setBlock(world, i + 3, j + 4, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 4, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 4, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 4, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 5, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 5, k - 1, JungleBlocks.mossystairs, 7, 2);
		bridge.setBlock(world, i + 3, j + 5, k - 2, Blocks.GRASS);
		bridge.setBlock(world, i + 3, j + 5, k - 3, Blocks.GRASS);
		bridge.setBlock(world, i + 3, j + 5, k - 4, Blocks.GRASS);
		bridge.setBlock(world, i + 3, j + 5, k - 5, JungleBlocks.mossystairs, 6, 2);
		bridge.setBlock(world, i + 3, j + 5, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 6, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 6, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 6, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 6, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 6, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 6, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 6, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 7, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 7, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 7, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 7, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 7, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 7, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 7, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 0, k - 0, Blocks.DIRT);
		bridge.setBlock(world, i + 4, j + 0, k - 1, Blocks.DIRT);
		bridge.setBlock(world, i + 4, j + 0, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 4, j + 0, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 4, j + 0, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 4, j + 0, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 4, j + 0, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 4, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 4, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 1, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 1, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 1, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 1, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 4, j + 2, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 2, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 2, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 2, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 2, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 2, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 3, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 3, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 4, j + 3, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 3, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 3, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 3, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 4, j + 3, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 4, k - 0, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 4, k - 1, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 4, k - 2, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 4, k - 3, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 4, k - 4, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 4, k - 5, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 4, k - 6, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 5, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 5, k - 1, Blocks.STONE_STAIRS, 7, 2);
		bridge.setBlock(world, i + 4, j + 5, k - 2, Blocks.GRASS);
		bridge.setBlock(world, i + 4, j + 5, k - 3, Blocks.GRASS);
		bridge.setBlock(world, i + 4, j + 5, k - 4, Blocks.GRASS);
		bridge.setBlock(world, i + 4, j + 5, k - 5, JungleBlocks.mossystairs, 6, 2);
		bridge.setBlock(world, i + 4, j + 5, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 6, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 6, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 6, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 6, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 6, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 6, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 6, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 7, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 7, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 7, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 7, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 7, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 7, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 4, j + 7, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 0, k - 0, Blocks.DIRT);
		bridge.setBlock(world, i + 5, j + 0, k - 1, Blocks.DIRT);
		bridge.setBlock(world, i + 5, j + 0, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 5, j + 0, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 5, j + 0, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 5, j + 0, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 5, j + 0, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 5, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 5, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 1, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 1, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 1, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 1, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 5, j + 2, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 2, k - 1, JungleBlocks.mossystairs, 3, 2); //TODO look in game copy iteration, for which blocks are wrong
		bridge.setBlock(world, i + 5, j + 2, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 2, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 2, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 2, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 2, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 3, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 3, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 3, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 3, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 3, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 3, k - 5, JungleBlocks.mossyStoneSteps, 2, 2);
		bridge.setBlock(world, i + 5, j + 3, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 4, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 4, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 4, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 4, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 4, k - 4, Blocks.LOG, 7, 2);
		bridge.setBlock(world, i + 5, j + 4, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 4, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 5, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 5, k - 1, Blocks.STONE_STAIRS, 7, 2);
		bridge.setBlock(world, i + 5, j + 5, k - 2, Blocks.GRASS);
		bridge.setBlock(world, i + 5, j + 5, k - 3, Blocks.GRASS);
		bridge.setBlock(world, i + 5, j + 5, k - 4, Blocks.GRASS);
		bridge.setBlock(world, i + 5, j + 5, k - 5, Blocks.STONE_STAIRS, 6, 2);
		bridge.setBlock(world, i + 5, j + 5, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 6, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 6, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 6, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 6, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 6, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 6, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 6, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 7, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 7, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 7, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 7, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 7, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 7, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 5, j + 7, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 0, k - 0, Blocks.DIRT);
		bridge.setBlock(world, i + 6, j + 0, k - 1, Blocks.DIRT);
		bridge.setBlock(world, i + 6, j + 0, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 6, j + 0, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 6, j + 0, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 6, j + 0, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 6, j + 0, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 6, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 1, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 1, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 1, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 1, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 2, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 2, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 2, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 2, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 2, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 3, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 3, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 3, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 3, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 3, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 3, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 3, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 4, k - 0, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 6, j + 4, k - 1, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 6, j + 4, k - 2, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 6, j + 4, k - 3, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 6, j + 4, k - 4, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 6, j + 4, k - 5, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 6, j + 4, k - 6, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 6, j + 5, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 5, k - 1, JungleBlocks.mossystairs, 7, 2);
		bridge.setBlock(world, i + 6, j + 5, k - 2, Blocks.GRASS);
		bridge.setBlock(world, i + 6, j + 5, k - 3, Blocks.GRASS);
		bridge.setBlock(world, i + 6, j + 5, k - 4, Blocks.GRASS);
		bridge.setBlock(world, i + 6, j + 5, k - 5, Blocks.STONE_STAIRS, 6, 2);
		bridge.setBlock(world, i + 6, j + 5, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 6, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 6, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 6, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 6, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 6, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 6, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 6, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 7, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 7, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 7, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 7, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 7, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 7, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 6, j + 7, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 0, k - 0, Blocks.DIRT);
		bridge.setBlock(world, i + 7, j + 0, k - 1, Blocks.DIRT);
		bridge.setBlock(world, i + 7, j + 0, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 7, j + 0, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 7, j + 0, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 7, j + 0, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 7, j + 0, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 7, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 7, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 1, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 1, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 1, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 1, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 7, j + 2, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 2, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 2, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 2, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 2, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 2, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 3, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 3, k - 1, Blocks.COBBLESTONE_WALL, 1, 2);
		bridge.setBlock(world, i + 7, j + 3, k - 2, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 7, j + 3, k - 3, JungleBlocks.mossyStoneSteps, 1, 2);
		bridge.setBlock(world, i + 7, j + 3, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 7, j + 3, k - 5, Blocks.COBBLESTONE_WALL, 1, 2);
		bridge.setBlock(world, i + 7, j + 3, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 4, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 4, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 4, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 4, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 4, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 4, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 4, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 5, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 5, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 5, k - 2, JungleBlocks.mossystairs, 5, 2);
		bridge.setBlock(world, i + 7, j + 5, k - 3, JungleBlocks.mossystairs, 5, 2);
		bridge.setBlock(world, i + 7, j + 5, k - 4, Blocks.STONE_STAIRS, 5, 2);
		bridge.setBlock(world, i + 7, j + 5, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 5, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 6, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 6, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 6, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 6, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 6, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 6, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 6, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 7, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 7, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 7, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 7, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 7, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 7, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 7, j + 7, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 0, k - 0, Blocks.DIRT);
		bridge.setBlock(world, i + 8, j + 0, k - 1, Blocks.DIRT);
		bridge.setBlock(world, i + 8, j + 0, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 8, j + 0, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 8, j + 0, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 8, j + 0, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 8, j + 0, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 8, j + 1, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 1, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 8, j + 1, k - 2, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 8, j + 1, k - 3, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 8, j + 1, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 8, j + 1, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 8, j + 1, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 2, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 2, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 2, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 2, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 2, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 2, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 2, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 3, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 3, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 3, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 3, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 3, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 3, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 3, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 4, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 4, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 4, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 4, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 4, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 4, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 4, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 5, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 5, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 5, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 5, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 5, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 5, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 5, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 6, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 6, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 6, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 6, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 6, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 6, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 6, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 7, k - 0, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 7, k - 1, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 7, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 7, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 7, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 7, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 8, j + 7, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 2, k - 1, Blocks.JUNGLE_DOOR, 3, 2);
		bridge.setBlock(world, i + 3, j + 3, k - 1, Blocks.JUNGLE_DOOR, 10, 2);
		bridge.setBlock(world, i + 6, j + 2, k - 3, Blocks.TORCH, 2, 2);
		
		if(rand.nextInt(2)==0) {
			
			BlockPos pos = new BlockPos(i, j, k);

			TileEntityChest tec;

			if(world.getBlockState(pos.add(6, 0, -2)).getBlock() != Blocks.AIR)
			{
				bridge.setBlock(world, i + 6, j + 1, k - 2, Blocks.CHEST, 2, 2);
				
				tec = (TileEntityChest)world.getTileEntity(pos.add(6, 1, -2));
				
				if(tec != null)
				{
					tec.setLootTable(fillchest, rand.nextLong());
				}
			}
		}
		
		return true;
	}
	
	@Override
	public boolean generate(World wrld, Random rnd, BlockPos pos) {

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		return this.generate(wrld, rnd, x, y, z);
	}
}