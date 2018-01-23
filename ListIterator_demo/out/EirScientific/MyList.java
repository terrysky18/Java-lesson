package com.EirScientific;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Terry Song on 23/11/2017.
 */
public class MyList {

	private ArrayList<Integer> list1;

	public MyList() {
		list1 = new ArrayList<Integer>();
		this.initialiseList();
	}

	public void PrintList() {
		ListIterator iter = list1.listIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public void NewList() {
		for (int i=0; i<list1.size(); i++) {
			list1.set(i, i*i);
		}
	}

	@Override
	public String toString() {
		return "MyList{" +
				"list1=" + list1 +
				'}';
	}

	private void initialiseList() {
		for (int i=0; i<10; i++) {
			list1.add(i);
		}
	}
}
