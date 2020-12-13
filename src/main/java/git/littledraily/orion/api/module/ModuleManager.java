package git.littledraily.orion.api.module;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;

public class ModuleManager {
    public static ArrayList<Module> modules = new ArrayList<>();

    public static void init() {
        Reflections reflections = new Reflections("git.littledraily.orion.impl.modules");
        reflections.getSubTypesOf(Module.class).forEach(aClass ->{
            try{
                Module module = aClass.getConstructor().newInstance();
                modules.add(module);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public static ArrayList<Module> getModules() {
        return modules;
    }

    public static Module getModuleByName(String name) {
        return modules.stream().filter(module -> module.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }



}