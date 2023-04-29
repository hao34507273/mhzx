/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.Consts;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.Logs;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.Listenable;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class MultiGender
/*     */   extends XBean
/*     */   implements xbean.MultiGender
/*     */ {
/*     */   private LinkedList<Integer> genders;
/*     */   private long switch_time;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  31 */     this.genders.clear();
/*  32 */     this.switch_time = 0L;
/*     */   }
/*     */   
/*     */   MultiGender(int paramInt, XBean paramXBean, String paramString)
/*     */   {
/*  37 */     super(paramXBean, paramString);
/*  38 */     this.genders = new LinkedList();
/*     */   }
/*     */   
/*     */   public MultiGender()
/*     */   {
/*  43 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MultiGender(MultiGender paramMultiGender)
/*     */   {
/*  48 */     this(paramMultiGender, null, null);
/*     */   }
/*     */   
/*     */   MultiGender(xbean.MultiGender paramMultiGender, XBean paramXBean, String paramString)
/*     */   {
/*  53 */     super(paramXBean, paramString);
/*  54 */     if ((paramMultiGender instanceof MultiGender)) {
/*  55 */       assign((MultiGender)paramMultiGender);
/*  56 */     } else if ((paramMultiGender instanceof Data)) {
/*  57 */       assign((Data)paramMultiGender);
/*  58 */     } else if ((paramMultiGender instanceof Const)) {
/*  59 */       assign(((Const)paramMultiGender).nThis());
/*     */     } else {
/*  61 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MultiGender paramMultiGender)
/*     */   {
/*  67 */     paramMultiGender._xdb_verify_unsafe_();
/*  68 */     this.genders = new LinkedList();
/*  69 */     this.genders.addAll(paramMultiGender.genders);
/*  70 */     this.switch_time = paramMultiGender.switch_time;
/*     */   }
/*     */   
/*     */   private void assign(Data paramData)
/*     */   {
/*  75 */     this.genders = new LinkedList();
/*  76 */     this.genders.addAll(paramData.genders);
/*  77 */     this.switch_time = paramData.switch_time;
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream paramOctetsStream)
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     paramOctetsStream.compact_uint32(this.genders.size());
/*  84 */     for (Integer localInteger : this.genders) {
/*  85 */       paramOctetsStream.marshal(localInteger.intValue());
/*     */     }
/*  87 */     paramOctetsStream.marshal(this.switch_time);
/*  88 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*     */     throws MarshalException
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*  95 */     for (int i = paramOctetsStream.uncompact_uint32(); i > 0; i--)
/*     */     {
/*  97 */       int j = 0;
/*  98 */       j = paramOctetsStream.unmarshal_int();
/*  99 */       this.genders.add(Integer.valueOf(j));
/*     */     }
/* 101 */     this.switch_time = paramOctetsStream.unmarshal_long();
/* 102 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public int getSerializedSize()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     int i = 0;
/* 109 */     for (Integer localInteger : this.genders) {
/* 110 */       i += CodedOutputStream.computeInt32Size(1, localInteger.intValue());
/*     */     }
/* 112 */     i += CodedOutputStream.computeInt64Size(2, this.switch_time);
/* 113 */     return i;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream paramCodedOutputStream)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 119 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 122 */       for (Integer localInteger : this.genders) {
/* 123 */         paramCodedOutputStream.writeInt32(1, localInteger.intValue());
/*     */       }
/* 125 */       paramCodedOutputStream.writeInt64(2, this.switch_time);
/*     */     }
/*     */     catch (IOException localIOException)
/*     */     {
/* 129 */       throw new InvalidProtocolBufferException(localIOException).setUnfinishedMessage(this);
/*     */     }
/* 131 */     return paramCodedOutputStream;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream paramCodedInputStream)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 140 */       int i = 0;
/* 141 */       while (i == 0)
/*     */       {
/* 143 */         int j = paramCodedInputStream.readTag();
/* 144 */         switch (j)
/*     */         {
/*     */         case 0: 
/* 147 */           i = 1;
/* 148 */           break;
/*     */         case 8: 
/* 150 */           int k = 0;
/* 151 */           k = paramCodedInputStream.readInt32();
/* 152 */           this.genders.add(Integer.valueOf(k));
/* 153 */           break;
/*     */         case 16: 
/* 155 */           this.switch_time = paramCodedInputStream.readInt64();
/* 156 */           break;
/*     */         default: 
/* 158 */           if (!CodedInputStream.skipUnknownField(j, paramCodedInputStream)) {
/* 159 */             i = 1;
/*     */           }
/*     */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
/*     */     {
/* 167 */       throw localInvalidProtocolBufferException.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException localIOException)
/*     */     {
/* 171 */       throw new InvalidProtocolBufferException(localIOException).setUnfinishedMessage(this);
/*     */     }
/* 173 */     return paramCodedInputStream;
/*     */   }
/*     */   
/*     */   public xbean.MultiGender copy()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new MultiGender(this);
/*     */   }
/*     */   
/*     */   public xbean.MultiGender toData()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MultiGender toBean()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new MultiGender(this);
/*     */   }
/*     */   
/*     */   public xbean.MultiGender toDataIf()
/*     */   {
/* 196 */     _xdb_verify_unsafe_();
/* 197 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MultiGender toBeanIf()
/*     */   {
/* 202 */     _xdb_verify_unsafe_();
/* 203 */     return this;
/*     */   }
/*     */   
/*     */   public Bean toConst()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return new Const(null);
/*     */   }
/*     */   
/*     */   public List<Integer> getGenders()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return Logs.logList(new LogKey(this, "genders"), this.genders);
/*     */   }
/*     */   
/*     */   public List<Integer> getGendersAsData()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/*     */     
/* 222 */     MultiGender localMultiGender = this;
/* 223 */     LinkedList localLinkedList = new LinkedList();
/* 224 */     localLinkedList.addAll(localMultiGender.genders);
/* 225 */     return localLinkedList;
/*     */   }
/*     */   
/*     */   public long getSwitch_time()
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     return this.switch_time;
/*     */   }
/*     */   
/*     */   public void setSwitch_time(long paramLong)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     Logs.logIf(new LogKey(this, "switch_time")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 241 */         new LogLong(this, MultiGender.this.switch_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             MultiGender.this.switch_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.switch_time = paramLong;
/*     */   }
/*     */   
/*     */   public final boolean equals(Object paramObject)
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     MultiGender localMultiGender = null;
/* 257 */     if ((paramObject instanceof MultiGender)) {
/* 258 */       localMultiGender = (MultiGender)paramObject;
/* 259 */     } else if ((paramObject instanceof Const)) {
/* 260 */       localMultiGender = ((Const)paramObject).nThis();
/*     */     } else {
/* 262 */       return false;
/*     */     }
/* 264 */     if (!this.genders.equals(localMultiGender.genders)) {
/* 265 */       return false;
/*     */     }
/* 267 */     if (this.switch_time != localMultiGender.switch_time) {
/* 268 */       return false;
/*     */     }
/* 270 */     return true;
/*     */   }
/*     */   
/*     */   public final int hashCode()
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     int i = 0;
/* 277 */     i += this.genders.hashCode();
/* 278 */     i = (int)(i + this.switch_time);
/* 279 */     return i;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 284 */     _xdb_verify_unsafe_();
/* 285 */     StringBuilder localStringBuilder = new StringBuilder();
/* 286 */     localStringBuilder.append("(");
/* 287 */     localStringBuilder.append(this.genders);
/* 288 */     localStringBuilder.append(",");
/* 289 */     localStringBuilder.append(this.switch_time);
/* 290 */     localStringBuilder.append(")");
/* 291 */     return localStringBuilder.toString();
/*     */   }
/*     */   
/*     */   public Listenable newListenable()
/*     */   {
/* 296 */     ListenableBean localListenableBean = new ListenableBean();
/* 297 */     localListenableBean.add(new ListenableChanged().setVarName("genders"));
/* 298 */     localListenableBean.add(new ListenableChanged().setVarName("switch_time"));
/* 299 */     return localListenableBean;
/*     */   }
/*     */   
/*     */   private class Const
/*     */     implements xbean.MultiGender
/*     */   {
/*     */     private Const() {}
/*     */     
/*     */     MultiGender nThis()
/*     */     {
/* 309 */       return MultiGender.this;
/*     */     }
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 314 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xbean.MultiGender copy()
/*     */     {
/* 319 */       return MultiGender.this.copy();
/*     */     }
/*     */     
/*     */     public xbean.MultiGender toData()
/*     */     {
/* 324 */       return MultiGender.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MultiGender toBean()
/*     */     {
/* 329 */       return MultiGender.this.toBean();
/*     */     }
/*     */     
/*     */     public xbean.MultiGender toDataIf()
/*     */     {
/* 334 */       return MultiGender.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MultiGender toBeanIf()
/*     */     {
/* 339 */       return MultiGender.this.toBeanIf();
/*     */     }
/*     */     
/*     */     public List<Integer> getGenders()
/*     */     {
/* 344 */       MultiGender.this._xdb_verify_unsafe_();
/* 345 */       return Consts.constList(MultiGender.this.genders);
/*     */     }
/*     */     
/*     */     public List<Integer> getGendersAsData()
/*     */     {
/* 350 */       MultiGender.this._xdb_verify_unsafe_();
/*     */       
/* 352 */       MultiGender localMultiGender = MultiGender.this;
/* 353 */       LinkedList localLinkedList = new LinkedList();
/* 354 */       localLinkedList.addAll(localMultiGender.genders);
/* 355 */       return localLinkedList;
/*     */     }
/*     */     
/*     */     public long getSwitch_time()
/*     */     {
/* 360 */       MultiGender.this._xdb_verify_unsafe_();
/* 361 */       return MultiGender.this.switch_time;
/*     */     }
/*     */     
/*     */     public void setSwitch_time(long paramLong)
/*     */     {
/* 366 */       MultiGender.this._xdb_verify_unsafe_();
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst()
/*     */     {
/* 372 */       MultiGender.this._xdb_verify_unsafe_();
/* 373 */       return this;
/*     */     }
/*     */     
/*     */     public boolean isConst()
/*     */     {
/* 378 */       MultiGender.this._xdb_verify_unsafe_();
/* 379 */       return true;
/*     */     }
/*     */     
/*     */     public boolean isData()
/*     */     {
/* 384 */       return MultiGender.this.isData();
/*     */     }
/*     */     
/*     */     public OctetsStream marshal(OctetsStream paramOctetsStream)
/*     */     {
/* 389 */       return MultiGender.this.marshal(paramOctetsStream);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*     */       throws MarshalException
/*     */     {
/* 395 */       MultiGender.this._xdb_verify_unsafe_();
/* 396 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public int getSerializedSize()
/*     */     {
/* 401 */       return MultiGender.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream paramCodedOutputStream)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 407 */       return MultiGender.this.marshal(paramCodedOutputStream);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream paramCodedInputStream)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 413 */       MultiGender.this._xdb_verify_unsafe_();
/* 414 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent()
/*     */     {
/* 419 */       return MultiGender.this.xdbParent();
/*     */     }
/*     */     
/*     */     public boolean xdbManaged()
/*     */     {
/* 424 */       return MultiGender.this.xdbManaged();
/*     */     }
/*     */     
/*     */     public String xdbVarname()
/*     */     {
/* 429 */       return MultiGender.this.xdbVarname();
/*     */     }
/*     */     
/*     */     public Long xdbObjId()
/*     */     {
/* 434 */       return MultiGender.this.xdbObjId();
/*     */     }
/*     */     
/*     */     public boolean equals(Object paramObject)
/*     */     {
/* 439 */       return MultiGender.this.equals(paramObject);
/*     */     }
/*     */     
/*     */     public int hashCode()
/*     */     {
/* 444 */       return MultiGender.this.hashCode();
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/* 449 */       return MultiGender.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class Data
/*     */     implements xbean.MultiGender
/*     */   {
/*     */     private LinkedList<Integer> genders;
/*     */     private long switch_time;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 466 */       this.genders = new LinkedList();
/*     */     }
/*     */     
/*     */     Data(xbean.MultiGender paramMultiGender)
/*     */     {
/* 471 */       if ((paramMultiGender instanceof MultiGender)) {
/* 472 */         assign((MultiGender)paramMultiGender);
/* 473 */       } else if ((paramMultiGender instanceof Data)) {
/* 474 */         assign((Data)paramMultiGender);
/* 475 */       } else if ((paramMultiGender instanceof MultiGender.Const)) {
/* 476 */         assign(((MultiGender.Const)paramMultiGender).nThis());
/*     */       } else {
/* 478 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MultiGender paramMultiGender)
/*     */     {
/* 484 */       this.genders = new LinkedList();
/* 485 */       this.genders.addAll(paramMultiGender.genders);
/* 486 */       this.switch_time = paramMultiGender.switch_time;
/*     */     }
/*     */     
/*     */     private void assign(Data paramData)
/*     */     {
/* 491 */       this.genders = new LinkedList();
/* 492 */       this.genders.addAll(paramData.genders);
/* 493 */       this.switch_time = paramData.switch_time;
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream paramOctetsStream)
/*     */     {
/* 498 */       paramOctetsStream.compact_uint32(this.genders.size());
/* 499 */       for (Integer localInteger : this.genders) {
/* 500 */         paramOctetsStream.marshal(localInteger.intValue());
/*     */       }
/* 502 */       paramOctetsStream.marshal(this.switch_time);
/* 503 */       return paramOctetsStream;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*     */       throws MarshalException
/*     */     {
/* 509 */       for (int i = paramOctetsStream.uncompact_uint32(); i > 0; i--)
/*     */       {
/* 511 */         int j = 0;
/* 512 */         j = paramOctetsStream.unmarshal_int();
/* 513 */         this.genders.add(Integer.valueOf(j));
/*     */       }
/* 515 */       this.switch_time = paramOctetsStream.unmarshal_long();
/* 516 */       return paramOctetsStream;
/*     */     }
/*     */     
/*     */     public final int getSerializedSize()
/*     */     {
/* 521 */       int i = 0;
/* 522 */       for (Integer localInteger : this.genders) {
/* 523 */         i += CodedOutputStream.computeInt32Size(1, localInteger.intValue());
/*     */       }
/* 525 */       i += CodedOutputStream.computeInt64Size(2, this.switch_time);
/* 526 */       return i;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream paramCodedOutputStream)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 534 */         for (Integer localInteger : this.genders) {
/* 535 */           paramCodedOutputStream.writeInt32(1, localInteger.intValue());
/*     */         }
/* 537 */         paramCodedOutputStream.writeInt64(2, this.switch_time);
/*     */       }
/*     */       catch (IOException localIOException)
/*     */       {
/* 541 */         throw new InvalidProtocolBufferException(localIOException).setUnfinishedMessage(this);
/*     */       }
/* 543 */       return paramCodedOutputStream;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream paramCodedInputStream)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 551 */         int i = 0;
/* 552 */         while (i == 0)
/*     */         {
/* 554 */           int j = paramCodedInputStream.readTag();
/* 555 */           switch (j)
/*     */           {
/*     */           case 0: 
/* 558 */             i = 1;
/* 559 */             break;
/*     */           case 8: 
/* 561 */             int k = 0;
/* 562 */             k = paramCodedInputStream.readInt32();
/* 563 */             this.genders.add(Integer.valueOf(k));
/* 564 */             break;
/*     */           case 16: 
/* 566 */             this.switch_time = paramCodedInputStream.readInt64();
/* 567 */             break;
/*     */           default: 
/* 569 */             if (!CodedInputStream.skipUnknownField(j, paramCodedInputStream)) {
/* 570 */               i = 1;
/*     */             }
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
/*     */       {
/* 578 */         throw localInvalidProtocolBufferException.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException localIOException)
/*     */       {
/* 582 */         throw new InvalidProtocolBufferException(localIOException).setUnfinishedMessage(this);
/*     */       }
/* 584 */       return paramCodedInputStream;
/*     */     }
/*     */     
/*     */     public xbean.MultiGender copy()
/*     */     {
/* 589 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MultiGender toData()
/*     */     {
/* 594 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MultiGender toBean()
/*     */     {
/* 599 */       return new MultiGender(this, null, null);
/*     */     }
/*     */     
/*     */     public xbean.MultiGender toDataIf()
/*     */     {
/* 604 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MultiGender toBeanIf()
/*     */     {
/* 609 */       return new MultiGender(this, null, null);
/*     */     }
/*     */     
/*     */     public boolean xdbManaged()
/*     */     {
/* 614 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent()
/*     */     {
/* 619 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname()
/*     */     {
/* 624 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId()
/*     */     {
/* 629 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst()
/*     */     {
/* 634 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst()
/*     */     {
/* 639 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData()
/*     */     {
/* 644 */       return true;
/*     */     }
/*     */     
/*     */     public List<Integer> getGenders()
/*     */     {
/* 649 */       return this.genders;
/*     */     }
/*     */     
/*     */     public List<Integer> getGendersAsData()
/*     */     {
/* 654 */       return this.genders;
/*     */     }
/*     */     
/*     */     public long getSwitch_time()
/*     */     {
/* 659 */       return this.switch_time;
/*     */     }
/*     */     
/*     */     public void setSwitch_time(long paramLong)
/*     */     {
/* 664 */       this.switch_time = paramLong;
/*     */     }
/*     */     
/*     */     public final boolean equals(Object paramObject)
/*     */     {
/* 669 */       if (!(paramObject instanceof Data)) {
/* 670 */         return false;
/*     */       }
/* 672 */       Data localData = (Data)paramObject;
/* 673 */       if (!this.genders.equals(localData.genders)) {
/* 674 */         return false;
/*     */       }
/* 676 */       if (this.switch_time != localData.switch_time) {
/* 677 */         return false;
/*     */       }
/* 679 */       return true;
/*     */     }
/*     */     
/*     */     public final int hashCode()
/*     */     {
/* 684 */       int i = 0;
/* 685 */       i += this.genders.hashCode();
/* 686 */       i = (int)(i + this.switch_time);
/* 687 */       return i;
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/* 692 */       StringBuilder localStringBuilder = new StringBuilder();
/* 693 */       localStringBuilder.append("(");
/* 694 */       localStringBuilder.append(this.genders);
/* 695 */       localStringBuilder.append(",");
/* 696 */       localStringBuilder.append(this.switch_time);
/* 697 */       localStringBuilder.append(")");
/* 698 */       return localStringBuilder.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MultiGender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */