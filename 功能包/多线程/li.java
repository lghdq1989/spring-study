class FooBar {
    private int n;
    private Semaphore one = new Semaphore(0);
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    public FooBar(int n) {
        this.one = one;
        this.n = n;
        try {
            this.one.acquire();

        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void foo(Runnable printFoo) throws InterruptedException {
        this.one.release();
        firstJobDone.incrementAndGet();
        for (int i = 0; i < n; i++) {
            while(firstJobDone.get()%1==0){

            }
            printFoo.run();
            //printFoo.run() outputs "foo". Do not change or remove this line.
            firstJobDone.incrementAndGet();

        }

    }

    public void bar(Runnable printBar) throws InterruptedException {
        one.acquire();
        for (int i = 0; i < n; i++) {
            while(firstJobDone.get()%2==0){

            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            firstJobDone.incrementAndGet();
        }
        one.release();
    }
}