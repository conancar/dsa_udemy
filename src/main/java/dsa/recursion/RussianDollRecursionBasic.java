package dsa.recursion;

public class RussianDollRecursionBasic {

	public static void main(String[] args) {

		openRussianDollRecursive(4);
		openRussionDollNonRecursiveFirstDoll();
		System.out.println(powerOf2Recursive(3));
	}

	/**
	 * Basic recursion example. No loops but function calls itself. For each call result is kept on stack memory if not void like in this case.
	 * BASE CONDITION stops recursion, and it is numberOfDolls==1 in this case.
	 *
	 * @param numberOfDolls recursion depth
	 */
	private static void openRussianDollRecursive(int numberOfDolls) {
		if(numberOfDolls<0) { //unintentional constraint
			return ;
		}

		if (numberOfDolls == 1) { //base case stopping from infinite loops
			System.out.println("All dolls are opened!");
		} else {
			//System.out.println("I am doll number " + numberOfDolls);  // 4 3 2 1 in this case
			openRussianDollRecursive(numberOfDolls - 1);    //recursive flow f(n)=f(n-1)
			System.out.println("I am doll number " + numberOfDolls);  // 1 2 3 4  in this case
		}
	}


	//                STACK MEMORY LIFO
//   |                                      |
//   |                                      |
//   |                                      |
//   |   _________________________________  |

//	  |     openRussianDollRecursive(2)      |

//   |                                      |
//   |  _________________________________   |
//   |                                      |
//   |      openRussianDollRecursive(3)     |
//   |  _________________________________   |
//   |                                      |
//   |      openRussianDollRecursive(4)     |


	/**
	 * Non recusive solution
	 */                                                           //                STACK MEMORY LIFO
	static void openRussionDollNonRecursiveFirstDoll() {         //   |                                      |
		secondDoll();                                              //   |                                      |
		System.out.println("All dolls are opened!");               //   |                                      |
	}                                                             //   |   _________________________________  |

	static void secondDoll() {                                     //   |                                      |
		thirdDoll();                                               //   |              thirdDoll()             |
		System.out.println("I am second doll");                    //   |                                      |
	}                                                             //   |  _________________________________   |

	static void thirdDoll() {                                      //   |                                      |
		fourthDoll();                                              //   |             secondDoll()             |
		System.out.println("I am third doll");                     //   |  _________________________________   |
	}                                                             //   |                                      |

	static void fourthDoll() {                                     //   |openRussionDollNonRecursiveFirstDoll()|
		System.out.println("I am fourth doll");                    //   |                                      |
	}




	static int powerOf2Recursive(int n){
		if(n==0){
			return 1;
		}else{
			return 2*powerOf2Recursive(n-1);  //result of powerOf2Recursive(n-1) is kept in stack
		}
	}
}
