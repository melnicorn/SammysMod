
# Sammy's Mod

## Setting up project

1. **Get MDK.**
From the command line, navigate to your Development folder. From the command line run `git clone https://github.com/melnicorn/SammysMod.git` which will pull down this repository into a folder called `SammysMod`. This has the MDK from Forge, and is unmodified.
2. **Import into Eclipse.**
In Eclipse, select the Import menu. Make sure and select `Gradle -> Existing Gradle project` as the import type, and select the `SammysMod` directory that you created in step 1. This might take a few minutes to process.

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
	- [ ] Your constructor needs to get the ``modEventBus`` from `FMLJavaModLoadingContext`, and add the ``setup`` method as a listener to the ``bus``.
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

If it runs correctly, check in your code! In Eclipse: `Team -> Commit`. **Make sure to add all of the `Unstaged Changes` to `Staged Changes` using the `++` button.**

## Creating a class for your Axe
1. Create a new package for items in ``src/main/java``, something like ``com.sammymc.items``.
2. Use Eclipse to make a new class for your Axe. When you're creating the class in Eclipse, make sure to select ``net.minecraft.world.item.SwordItem`` as the superclass, and check the "Constructors from superclass" checkbox before creating it.
	 - [ ] Use the ``New -> Class`` menu in Eclipse to create your Axe.
	 - [ ] Make sure the package you made for "items" is selected e.g. ``com.sammymc.items``.
	 - [ ] Select ``SwordItem`` as the superclass (``net.minecraft.world.item.SwordItem``)
	 - [ ] Make sure "Constructors from superclass" checkbox is checked
	 - [ ] Finish creating the class
3. You will not need most of the parameters in the constructor.
	- [ ] Delete everything except the `Properties` parameter.
	- [ ] Rename the `Properties` variable name to something that makes sense, e.g. `properties`. **Hint:** Use Eclipse ``refactor -> rename`` to rename the parameters.
	- [ ] We do still need to pass values to the super constructor. For now, just use the default Netherite sword values: `super(Tier.NETHERITE, 3, -2.4F, properties)`. We will change those later to be SUPER!
	- [ ] Finally, create a public, static, final String for the internal name of your Axe. Something similar to `String INTERNAL_NAME = "superaxe"`

## Registering your Axe
We now need to register your new Axe with Forge.
1. Create a new package `com.sammymc.setup`
2. Create a new class called `Registration` in the `setup` package, and add some code. Reference our previous tutorial for specifics. It needs: 
	- [ ] A private, final, static `DeferredRegister<Item>` called `ITEMS`
	- [ ] A public, final, static `RegistryObject` for your new Axe (e.g. `SUPERAXE`). Use the `INTERNAL_NAME` that you set up in your Axe class.
	- [ ] A static function called `init` that registers the `modEventBus` from `FMLJavaModLoadingContext` with your `ITEMS`.
3. Call the `Registration.init()` method from your `SuperWeapons` mod class in the constructor.

### Checkpoint
At this point you should be able to run your mod, start a new creative world, and give yourself your weapon using `/give Dev superweapons:superaxe`. Test and make sure it acts like a sword by summoning a skeleton `/summon skeleton` and killing it. It will still look like a big purple checkerboard box at this point.

If it runs correctly, check in your code! In Eclipse: `Team -> Commit`. **Make sure to add all of the `Unstaged Changes` to `Staged Changes` using the `++` button.**

## Making the Axe look like an Axe
We need to create the data generation objects so that we can create the json files that map the texture to your axe. If you remember from the tutorial, this part gave us the most trouble, so reach out if it's not working.
1. Make your axe texture using [Pixelart](https://www.pixilart.com/) or similar
	 - [ ] Save as `superaxe.png` or similar.
	 - [ ] In Eclipse, under `src/main/resources` create a package called `assets.superweapons.lang` and another called `assets.superweapons.textures.item`
	 - [ ] Paste the `superaxe.png` image from file explorer into `assets.superweapons.textures.item` inside Eclipse
2. Under `src/main/java` create a package for datagen `com.sammymc.datagen`
3. Create an `Items` class in the datagen package. Use Eclipse to create the class.
	- [ ] `Items` should use `ItemModelProvider` as the superclass
	- [ ] `Items` should `@Override` the `registerModels` function.
	- [ ] Using Eclipse to create the class will create a constructor. You can delete the `modid` parameter from the constructor, and pass in `SuperWeapons.MODID` into the call to `super(...)`
	- [ ] We will just use a single texture for our axe, so in `registerModels` call `singleTexture` with:
		- [ ] The path to the `SUPERAXE` registry
		- [ ] A new `resourceLocation` for `"item/handheld"`
		- [ ] `"layer0"`
		- [ ] A new `resourceLocation` for MODID and `"item/superaxe"`
4. Create a `DataGenerators` class in the datagen package.
	- [ ] The `DataGenerators` class needs the `@Mod.EventBusSubscriber` annotation on it.
	- [ ] It needs a public, static function on it called `gatherData` that takes a `GatherDataEvent` parameter, and the `@SubscribeEvent` annotation on the method.
	- [ ] At this point, this `gatherData` function should add `Items` as a provider to the `DataGenerator` if we are in client mode. (Refer to tutorial)

5. We should be able to run the `runData` launch configuration now which will generate `src/generated/resources/assets/superweapons/models/item/superaxe.json`. This is where it got tricky last time though, and we couldn't get the actual texture to load. Do the following:
	- [ ] At the top level in package explorer, right click the project and select "Refresh"
	- [ ] Right click again and select `New -> Source Folder`. For the Folder Name, browse and select `src/generated/resources` and click `Finish`.
	- [ ] Check in your code! In Eclipse: `Team -> Commit`. **Make sure to add all of the `Unstaged Changes` to `Staged Changes` using the `++` button.**
	- [ ] Get in touch with me!!! I think I can get it working, but it's tricky and involves completely deleting the project, and pulling it back in from Github.
