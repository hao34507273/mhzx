/*     */ package mzm.gsp.util;
/*     */ 
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import sun.misc.Unsafe;
/*     */ 
/*     */ public class AtomicRangeInteger extends Number implements java.io.Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 5533640171737883354L;
/*     */   private static final Unsafe unsafe;
/*     */   private static final long valueOffset;
/*     */   private final int min;
/*     */   private final int max;
/*     */   private final long units;
/*     */   private volatile int value;
/*     */   
/*     */   static
/*     */   {
/*     */     try
/*     */     {
/*  20 */       java.lang.reflect.Field field = AtomicInteger.class.getDeclaredField("unsafe");
/*  21 */       field.setAccessible(true);
/*  22 */       unsafe = (Unsafe)field.get(null);
/*  23 */       valueOffset = unsafe.objectFieldOffset(AtomicRangeInteger.class.getDeclaredField("value"));
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*  27 */       throw new Error(ex);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AtomicRangeInteger()
/*     */   {
/*  39 */     this(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
/*     */   }
/*     */   
/*     */   public AtomicRangeInteger(int min, int max)
/*     */   {
/*  44 */     this(min, max, min);
/*     */   }
/*     */   
/*     */   public AtomicRangeInteger(int min, int max, int initialValue)
/*     */   {
/*  49 */     if (min >= max)
/*     */     {
/*  51 */       throw new IllegalArgumentException("min >= max");
/*     */     }
/*     */     
/*  54 */     if ((initialValue < min) || (initialValue > max))
/*     */     {
/*  56 */       throw new IllegalArgumentException("initialValue < min || initialValue > max");
/*     */     }
/*     */     
/*  59 */     this.min = min;
/*  60 */     this.max = max;
/*  61 */     this.units = (this.max - this.min + 1L);
/*  62 */     this.value = initialValue;
/*     */   }
/*     */   
/*     */   public final int get()
/*     */   {
/*  67 */     return this.value;
/*     */   }
/*     */   
/*     */   public final void set(int newValue)
/*     */   {
/*  72 */     if ((newValue < this.min) || (newValue > this.max))
/*     */     {
/*  74 */       throw new IllegalArgumentException("newValue < min || newValue > max");
/*     */     }
/*     */     
/*  77 */     this.value = newValue;
/*     */   }
/*     */   
/*     */   public final void lazySet(int newValue)
/*     */   {
/*  82 */     if ((newValue < this.min) || (newValue > this.max))
/*     */     {
/*  84 */       throw new IllegalArgumentException("newValue < min || newValue > max");
/*     */     }
/*     */     
/*  87 */     unsafe.putOrderedInt(this, valueOffset, newValue);
/*     */   }
/*     */   
/*     */   public final int getAndSet(int newValue)
/*     */   {
/*  92 */     if ((newValue < this.min) || (newValue > this.max))
/*     */     {
/*  94 */       throw new IllegalArgumentException("newValue < min || newValue > max");
/*     */     }
/*     */     
/*     */     for (;;)
/*     */     {
/*  99 */       int current = get();
/* 100 */       if (doCompareAndSet(current, newValue))
/*     */       {
/* 102 */         return current;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public final boolean compareAndSet(int expect, int update)
/*     */   {
/* 109 */     if ((update < this.min) || (update > this.max))
/*     */     {
/* 111 */       throw new IllegalArgumentException("update < min || update > max");
/*     */     }
/*     */     
/* 114 */     return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
/*     */   }
/*     */   
/*     */   public final boolean weakCompareAndSet(int expect, int update)
/*     */   {
/* 119 */     if ((update < this.min) || (update > this.max))
/*     */     {
/* 121 */       throw new IllegalArgumentException("update < min || update > max");
/*     */     }
/*     */     
/* 124 */     return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
/*     */   }
/*     */   
/*     */   public final int getAndIncrement()
/*     */   {
/*     */     for (;;)
/*     */     {
/* 131 */       int current = get();
/* 132 */       int next = calcIncrementNext(current);
/* 133 */       if (doCompareAndSet(current, next))
/*     */       {
/* 135 */         return current;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public final int getAndDecrement()
/*     */   {
/*     */     for (;;)
/*     */     {
/* 144 */       int current = get();
/* 145 */       int next = calcDecrementNext(current);
/* 146 */       if (doCompareAndSet(current, next))
/*     */       {
/* 148 */         return current;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public final int getAndAdd(int delta)
/*     */   {
/*     */     for (;;)
/*     */     {
/* 157 */       int current = get();
/* 158 */       int next = calcNext(current, delta);
/* 159 */       if (doCompareAndSet(current, next))
/*     */       {
/* 161 */         return current;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public final int incrementAndGet()
/*     */   {
/*     */     for (;;)
/*     */     {
/* 170 */       int current = get();
/* 171 */       int next = calcIncrementNext(current);
/* 172 */       if (doCompareAndSet(current, next))
/*     */       {
/* 174 */         return next;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public final int decrementAndGet()
/*     */   {
/*     */     for (;;)
/*     */     {
/* 183 */       int current = get();
/* 184 */       int next = calcDecrementNext(current);
/* 185 */       if (doCompareAndSet(current, next))
/*     */       {
/* 187 */         return next;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public final int addAndGet(int delta)
/*     */   {
/*     */     for (;;)
/*     */     {
/* 196 */       int current = get();
/* 197 */       int next = calcNext(current, delta);
/* 198 */       if (doCompareAndSet(current, next))
/*     */       {
/* 200 */         return next;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 207 */     return Integer.toString(get());
/*     */   }
/*     */   
/*     */   public int intValue()
/*     */   {
/* 212 */     return get();
/*     */   }
/*     */   
/*     */   public long longValue()
/*     */   {
/* 217 */     return get();
/*     */   }
/*     */   
/*     */   public float floatValue()
/*     */   {
/* 222 */     return get();
/*     */   }
/*     */   
/*     */   public double doubleValue()
/*     */   {
/* 227 */     return get();
/*     */   }
/*     */   
/*     */   private boolean doCompareAndSet(int expect, int update)
/*     */   {
/* 232 */     return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
/*     */   }
/*     */   
/*     */   private int calcIncrementNext(int current)
/*     */   {
/* 237 */     if (current >= this.max)
/*     */     {
/* 239 */       return this.min;
/*     */     }
/*     */     
/*     */ 
/* 243 */     return current + 1;
/*     */   }
/*     */   
/*     */ 
/*     */   private int calcDecrementNext(int current)
/*     */   {
/* 249 */     if (current <= this.min)
/*     */     {
/* 251 */       return this.max;
/*     */     }
/*     */     
/*     */ 
/* 255 */     return current - 1;
/*     */   }
/*     */   
/*     */ 
/*     */   private int calcNext(int current, int delta)
/*     */   {
/* 261 */     int next = 0;
/* 262 */     if (delta == 0)
/*     */     {
/* 264 */       next = current;
/*     */     }
/* 266 */     else if (delta >= 0)
/*     */     {
/* 268 */       long remUnits = this.max - current;
/* 269 */       if (remUnits >= delta)
/*     */       {
/* 271 */         next = current + delta;
/*     */       }
/*     */       else
/*     */       {
/* 275 */         remUnits = delta - remUnits - 1L;
/* 276 */         next = (int)(this.min + remainder(remUnits));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 281 */       long remUnits = current - this.min;
/* 282 */       if (remUnits >= -delta)
/*     */       {
/* 284 */         next = current + delta;
/*     */       }
/*     */       else
/*     */       {
/* 288 */         remUnits = -delta - remUnits - 1L;
/* 289 */         next = (int)(this.max - remainder(remUnits));
/*     */       }
/*     */     }
/* 292 */     return next;
/*     */   }
/*     */   
/*     */   private final long remainder(long num)
/*     */   {
/* 297 */     return num % this.units;
/*     */   }
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/* 302 */     AtomicInteger atomicInteger = new AtomicInteger(-2147483628);
/* 303 */     AtomicRangeInteger atomicRangeInteger = new AtomicRangeInteger(Integer.MIN_VALUE, Integer.MAX_VALUE, -2147483628);
/*     */     
/*     */ 
/* 306 */     java.util.Random random = new java.util.Random();
/* 307 */     for (int i = 0; i < 10000; i++)
/*     */     {
/* 309 */       int delta = -random.nextInt(Integer.MAX_VALUE);
/* 310 */       if (atomicInteger.getAndAdd(delta) != atomicRangeInteger.getAndAdd(delta))
/*     */       {
/* 312 */         System.out.println("xxxxxxxxxxxxxxxxxx" + i);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\AtomicRangeInteger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */