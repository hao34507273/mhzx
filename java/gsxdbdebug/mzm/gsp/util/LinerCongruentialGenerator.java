/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ 
/*     */ public class LinerCongruentialGenerator
/*     */ {
/*     */   private static final int multiplier = 33797;
/*     */   private static final int addend = 1;
/*     */   private static final int mask = -1;
/*     */   private final AtomicInteger seed;
/*     */   private double nextNextGaussian;
/*     */   
/*     */   public LinerCongruentialGenerator(int seed)
/*     */   {
/*  15 */     this.seed = new AtomicInteger(0);
/*  16 */     setSeed(seed);
/*     */   }
/*     */   
/*     */   public synchronized void setSeed(int seed)
/*     */   {
/*  21 */     seed = (seed ^ 0x8405) & 0xFFFFFFFF;
/*  22 */     this.seed.set(seed);
/*  23 */     this.haveNextNextGaussian = false;
/*     */   }
/*     */   
/*     */ 
/*     */   protected int next(int bits)
/*     */   {
/*  29 */     AtomicInteger seed = this.seed;
/*     */     int oldseed;
/*     */     int nextseed;
/*  32 */     do { oldseed = seed.get();
/*  33 */       nextseed = oldseed * 33797 + 1 & 0xFFFFFFFF;
/*     */     }
/*  35 */     while (!seed.compareAndSet(oldseed, nextseed));
/*  36 */     return nextseed >>> 32 - bits;
/*     */   }
/*     */   
/*     */   public void nextBytes(byte[] bytes)
/*     */   {
/*  41 */     int i = 0; for (int len = bytes.length; i < len;)
/*     */     {
/*  43 */       int rnd = nextInt(); for (int n = Math.min(len - i, 4); n-- > 0; rnd >>= 8)
/*     */       {
/*  45 */         bytes[(i++)] = ((byte)rnd);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public int nextInt()
/*     */   {
/*  52 */     return next(32);
/*     */   }
/*     */   
/*     */   public int nextInt(int n)
/*     */   {
/*  57 */     if (n <= 0)
/*     */     {
/*  59 */       throw new IllegalArgumentException("n must be positive");
/*     */     }
/*     */     
/*  62 */     if ((n & -n) == n)
/*     */     {
/*  64 */       return (int)(n * next(31) >> 31);
/*     */     }
/*     */     int bits;
/*     */     int val;
/*     */     do
/*     */     {
/*  70 */       bits = next(31);
/*  71 */       val = bits % n;
/*     */     }
/*  73 */     while (bits - val + (n - 1) < 0);
/*  74 */     return val;
/*     */   }
/*     */   
/*     */ 
/*     */   public long nextLong()
/*     */   {
/*  80 */     return (next(32) << 32) + next(32);
/*     */   }
/*     */   
/*     */   public boolean nextBoolean()
/*     */   {
/*  85 */     return next(1) != 0;
/*     */   }
/*     */   
/*     */   public float nextFloat()
/*     */   {
/*  90 */     return next(24) / 1.6777216E7F;
/*     */   }
/*     */   
/*     */   public double nextDouble()
/*     */   {
/*  95 */     long num = (next(26) << 27) + next(27);
/*  96 */     double base = 9.007199254740992E15D;
/*  97 */     System.out.println(num);
/*  98 */     return num / 9.007199254740992E15D;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 103 */   private boolean haveNextNextGaussian = false;
/*     */   
/*     */ 
/*     */   public synchronized double nextGaussian()
/*     */   {
/* 108 */     if (this.haveNextNextGaussian)
/*     */     {
/* 110 */       this.haveNextNextGaussian = false;
/* 111 */       return this.nextNextGaussian;
/*     */     }
/*     */     double v1;
/*     */     double v2;
/*     */     double s;
/*     */     do
/*     */     {
/* 118 */       v1 = 2.0D * nextDouble() - 1.0D;
/* 119 */       v2 = 2.0D * nextDouble() - 1.0D;
/* 120 */       s = v1 * v1 + v2 * v2;
/*     */     }
/* 122 */     while ((s >= 1.0D) || (s == 0.0D));
/* 123 */     double multiplier = StrictMath.sqrt(-2.0D * StrictMath.log(s) / s);
/* 124 */     this.nextNextGaussian = (v2 * multiplier);
/* 125 */     this.haveNextNextGaussian = true;
/* 126 */     return v1 * multiplier;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\LinerCongruentialGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */