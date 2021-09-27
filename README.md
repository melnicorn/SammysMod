# Sammy's Mod

## Setting up project

1. **Get MDK.**
Download latest MDK [from Forge](https://files.minecraftforge.net/net/minecraftforge/forge/) and 	unzip it into your development directory. Rename the directory to something that makes sense for your project. E.g. "SuperAxe" or something cooler than that.
2. **Import into Eclipse.**
In Eclipse, select the Import menu. Make sure and select `Gradle -> Existing Gradle project` as the import type, and select the directory that you created in step 1. This might take a few minutes to process.

**Note:** It is totally fine in Eclipse to have both Minecraft-Tutorial open and your new project open, but it might be easy to mix stuff up. But it will be easier to reference the old tutorial if you keep it open. If you want to close it, right click on `Minecraft-Tutorial` in the package explorer and select `Delete`. Just don't check the checkbox to remove files from computer. If you do decide to keep it open, just make sure when you add new files, or import the launch configurations that you have the directory for your new project selected, not the old `Minecraft-Tutorial` one.

## Setting up your mod
1. **Decide on what name you want to use for your mod**
Decide what you want your mod to be called. It will need to have a displayable name (e.g. "Super Weapons Mod") and a name that Forge will use that doesn't have spaces or special characters (e.g. "superweaponsmod"). Also choose the package name that you will want to use for your project. The tutorial used ``com.mcjty``. You could use something like ``com.sammymc`` or whatever (I'll use ``com.sammymc`` for the descriptions in this doc). 
	1. Use Eclipse to create your package under ``src/main/java`` 
	2. Use Eclipse to create your mod class under ``src/main/java/com/sammymc``. It should have a standard Java class name that makes sense for your mod (upper case letter for each word in the name of the class) e.g. ``SuperWeapons``. This class does not need to extend from any other class.
2. **Fill our your mod class**
Without spelling out exactly what you need to do, there are several things your mod class needs to work. Reference the ``Minecraft-Tutorial`` project if you need help as a first step, then we can work together as a second step.
	- [ ] Set up a public constant string called ``MODID`` to use as the internal name of your mod (e.g. ``superweapons``.
	- [ ] Your class needs the ``@Mod`` annotation on it which should use ``MODID`` as it's name.
	- [ ] Your class needs an empty private function named ``setup`` which takes an ``FMLCommonSetupEvent`` parameter.
	- [ ] Your constructor needs to get the ``modEventBus`` from ``FMLLoadingContext``, and add the ``setup`` method as a listener to the ``bus``.
3. **Use your mod name**
We need to change several areas that use ``ExampleMod`` to use your internal mod name (what you set ``MODID`` equal to) and the name you want to see in Minecraft (e.g. "Super Weapons").
	- [ ] In ``src/main/resources/META-INF/mods.toml``:
		- [ ] ``modId="examplemod"``
		- [ ] ``displayName="Example Mod``
		- [ ] ``authors="Love, Cheese and small house plants``
		- [ ] ``[[dependencies.examplemod]]`` (change ``examplemod`` to your internal mod name)
	- [ ] Delete ``src/main/java/com/example/examplemod/ExampleMod.java``
	- [ ] In ``build.gradle`` (at the top level of the Eclipse project)
		- [ ] ``group = 'com.yourname.modid'`` -> e.g.: ``group = 'com.sammy.superweapons'``
		- [ ] ``archivesBaseName = 'modid'``
		- [ ] Somewhere around lines 59, 80, and 106 should be a reference to ``examplemod``. Change them to your mod id.
		- [ ] Around line 102, change the `args` value from `examplemod` to your mod id.

4. **Create the Launch Configurations**
	1. In Eclipse in the Gradle Tasks tab, run the ``forgegradle runs -> genEclipseRuns`` script to generate the launch configurations. This will take a few minutes to complete.
	2. Once that is done, import the three launch configurations into Eclipse using the Import menu. Select ``Run/Debug -> Launch Configurations`` for the import type. Make sure to have the correct directory selected in the Import window!

### Checkpoint
At this point you should be able to run the ``runClient`` configuration, launch Minecraft, and see your mod in the Mods menu. There's not much else you can do yet, but you shouldn't get any errors.

## Creating a class for your Axe
1. Create a new package for items in ``src/main/java``, something like ``com.sammymc.items``.
2. Use Eclipse to make a new class for your Axe. When you're creating the class in Eclipse, make sure to select ``net.minecraft.world.item.AxeItem`` as the superclass, and check the "Constructors from superclass" checkbox before creating it.
	 - [ ] Use the ``New -> Class`` menu in Eclipse to create your Axe.
	 - [ ] Make sure the package you made for "items" is selected e.g. ``com.sammymc.items``.
	 - [ ] Select ``SwordItem`` as the superclass (``net.minecraft.world.item.SwordItem``)
	 - [ ] Make sure "Constructors from superclass" checkbox is checked
	 - [ ] Finish creating the class
3. Rename the parameters in the constructor to something that makes sense. I think they should be something like ``Tier tier, int baseAttackDamage, float attackSpeed, Item.Properties properties``. **Hint:** Use Eclipse ``refactor -> rename`` to rename the parameters.
