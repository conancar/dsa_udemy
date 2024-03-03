package dsa.tree;


import java.util.Arrays;

public class MyTreeBasicOps {

	public static void main(String[] args){

		MyTreeBasicImpl<String> treeBasic=new MyTreeBasicImpl<>("Proizvodi");

		MyTreeBasicImpl<String> goriva=new MyTreeBasicImpl<>("Goriva");
		MyTreeBasicImpl<String> neGoriva=new MyTreeBasicImpl<>("Ne goriva");
		treeBasic.addChildren(Arrays.asList(goriva,neGoriva));

		MyTreeBasicImpl<String> dizeli=new MyTreeBasicImpl<>("dizeli");
		MyTreeBasicImpl<String> benzini=new MyTreeBasicImpl<>("benzini");
		MyTreeBasicImpl<String> gas=new MyTreeBasicImpl<>("gas");

		goriva.addChildren(Arrays.asList(dizeli,benzini,gas));

		MyTreeBasicImpl<String> hrana=new MyTreeBasicImpl<>("Hrana");
		MyTreeBasicImpl<String> delovi=new MyTreeBasicImpl<>("delovi");
		neGoriva.addChildren(Arrays.asList(hrana,delovi));

		MyTreeBasicImpl<String> ed=new MyTreeBasicImpl<>("ED");
		MyTreeBasicImpl<String> gdrive=new MyTreeBasicImpl<>("Gdrive");
		dizeli.addChildren(Arrays.asList(ed,gdrive));

		System.out.println(treeBasic.toString(0));
	}
}
