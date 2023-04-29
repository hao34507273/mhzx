/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class ItemBuyCount extends XBean implements xbean.ItemBuyCount
/*     */ {
/*     */   private long cleartime;
/*     */   private HashMap<Integer, Integer> id2count;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.cleartime = 0L;
/*  21 */     this.id2count.clear();
/*     */   }
/*     */   
/*     */   ItemBuyCount(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.cleartime = 0L;
/*  28 */     this.id2count = new HashMap();
/*     */   }
/*     */   
/*     */   public ItemBuyCount()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ItemBuyCount(ItemBuyCount _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ItemBuyCount(xbean.ItemBuyCount _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof ItemBuyCount)) { assign((ItemBuyCount)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ItemBuyCount _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.cleartime = _o_.cleartime;
/*  54 */     this.id2count = new HashMap();
/*  55 */     for (Map.Entry<Integer, Integer> _e_ : _o_.id2count.entrySet()) {
/*  56 */       this.id2count.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  61 */     this.cleartime = _o_.cleartime;
/*  62 */     this.id2count = new HashMap();
/*  63 */     for (Map.Entry<Integer, Integer> _e_ : _o_.id2count.entrySet()) {
/*  64 */       this.id2count.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.cleartime);
/*  72 */     _os_.compact_uint32(this.id2count.size());
/*  73 */     for (Map.Entry<Integer, Integer> _e_ : this.id2count.entrySet())
/*     */     {
/*  75 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  76 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     this.cleartime = _os_.unmarshal_long();
/*     */     
/*  87 */     int size = _os_.uncompact_uint32();
/*  88 */     if (size >= 12)
/*     */     {
/*  90 */       this.id2count = new HashMap(size * 2);
/*     */     }
/*  92 */     for (; size > 0; size--)
/*     */     {
/*  94 */       int _k_ = 0;
/*  95 */       _k_ = _os_.unmarshal_int();
/*  96 */       int _v_ = 0;
/*  97 */       _v_ = _os_.unmarshal_int();
/*  98 */       this.id2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     int _size_ = 0;
/* 109 */     _size_ += CodedOutputStream.computeInt64Size(1, this.cleartime);
/* 110 */     for (Map.Entry<Integer, Integer> _e_ : this.id2count.entrySet())
/*     */     {
/* 112 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 113 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       _output_.writeInt64(1, this.cleartime);
/* 125 */       for (Map.Entry<Integer, Integer> _e_ : this.id2count.entrySet())
/*     */       {
/* 127 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 128 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 133 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 135 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 141 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 144 */       boolean done = false;
/* 145 */       while (!done)
/*     */       {
/* 147 */         int tag = _input_.readTag();
/* 148 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 152 */           done = true;
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 157 */           this.cleartime = _input_.readInt64();
/* 158 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 162 */           int _k_ = 0;
/* 163 */           _k_ = _input_.readInt32();
/* 164 */           int readTag = _input_.readTag();
/* 165 */           if (16 != readTag)
/*     */           {
/* 167 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 169 */           int _v_ = 0;
/* 170 */           _v_ = _input_.readInt32();
/* 171 */           this.id2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 172 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 176 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 178 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 187 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ItemBuyCount copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new ItemBuyCount(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ItemBuyCount toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ItemBuyCount toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new ItemBuyCount(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ItemBuyCount toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ItemBuyCount toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getCleartime()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.cleartime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getId2count()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return xdb.Logs.logMap(new xdb.LogKey(this, "id2count"), this.id2count);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getId2countAsData()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/*     */     
/* 258 */     ItemBuyCount _o_ = this;
/* 259 */     Map<Integer, Integer> id2count = new HashMap();
/* 260 */     for (Map.Entry<Integer, Integer> _e_ : _o_.id2count.entrySet())
/* 261 */       id2count.put(_e_.getKey(), _e_.getValue());
/* 262 */     return id2count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCleartime(long _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new xdb.LogKey(this, "cleartime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogLong(this, ItemBuyCount.this.cleartime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             ItemBuyCount.this.cleartime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.cleartime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     ItemBuyCount _o_ = null;
/* 291 */     if ((_o1_ instanceof ItemBuyCount)) { _o_ = (ItemBuyCount)_o1_;
/* 292 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 293 */       return false;
/* 294 */     if (this.cleartime != _o_.cleartime) return false;
/* 295 */     if (!this.id2count.equals(_o_.id2count)) return false;
/* 296 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     int _h_ = 0;
/* 304 */     _h_ = (int)(_h_ + this.cleartime);
/* 305 */     _h_ += this.id2count.hashCode();
/* 306 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     StringBuilder _sb_ = new StringBuilder();
/* 314 */     _sb_.append("(");
/* 315 */     _sb_.append(this.cleartime);
/* 316 */     _sb_.append(",");
/* 317 */     _sb_.append(this.id2count);
/* 318 */     _sb_.append(")");
/* 319 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 325 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 326 */     lb.add(new xdb.logs.ListenableChanged().setVarName("cleartime"));
/* 327 */     lb.add(new xdb.logs.ListenableMap().setVarName("id2count"));
/* 328 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ItemBuyCount {
/*     */     private Const() {}
/*     */     
/*     */     ItemBuyCount nThis() {
/* 335 */       return ItemBuyCount.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ItemBuyCount copy()
/*     */     {
/* 347 */       return ItemBuyCount.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ItemBuyCount toData()
/*     */     {
/* 353 */       return ItemBuyCount.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ItemBuyCount toBean()
/*     */     {
/* 358 */       return ItemBuyCount.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ItemBuyCount toDataIf()
/*     */     {
/* 364 */       return ItemBuyCount.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ItemBuyCount toBeanIf()
/*     */     {
/* 369 */       return ItemBuyCount.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCleartime()
/*     */     {
/* 376 */       ItemBuyCount.this._xdb_verify_unsafe_();
/* 377 */       return ItemBuyCount.this.cleartime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getId2count()
/*     */     {
/* 384 */       ItemBuyCount.this._xdb_verify_unsafe_();
/* 385 */       return xdb.Consts.constMap(ItemBuyCount.this.id2count);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getId2countAsData()
/*     */     {
/* 392 */       ItemBuyCount.this._xdb_verify_unsafe_();
/*     */       
/* 394 */       ItemBuyCount _o_ = ItemBuyCount.this;
/* 395 */       Map<Integer, Integer> id2count = new HashMap();
/* 396 */       for (Map.Entry<Integer, Integer> _e_ : _o_.id2count.entrySet())
/* 397 */         id2count.put(_e_.getKey(), _e_.getValue());
/* 398 */       return id2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCleartime(long _v_)
/*     */     {
/* 405 */       ItemBuyCount.this._xdb_verify_unsafe_();
/* 406 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 412 */       ItemBuyCount.this._xdb_verify_unsafe_();
/* 413 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 419 */       ItemBuyCount.this._xdb_verify_unsafe_();
/* 420 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 426 */       return ItemBuyCount.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 432 */       return ItemBuyCount.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 438 */       ItemBuyCount.this._xdb_verify_unsafe_();
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 445 */       return ItemBuyCount.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 451 */       return ItemBuyCount.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 457 */       ItemBuyCount.this._xdb_verify_unsafe_();
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 464 */       return ItemBuyCount.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 470 */       return ItemBuyCount.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 476 */       return ItemBuyCount.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 482 */       return ItemBuyCount.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 488 */       return ItemBuyCount.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 494 */       return ItemBuyCount.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 500 */       return ItemBuyCount.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ItemBuyCount
/*     */   {
/*     */     private long cleartime;
/*     */     
/*     */     private HashMap<Integer, Integer> id2count;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 519 */       this.cleartime = 0L;
/* 520 */       this.id2count = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.ItemBuyCount _o1_)
/*     */     {
/* 525 */       if ((_o1_ instanceof ItemBuyCount)) { assign((ItemBuyCount)_o1_);
/* 526 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 527 */       } else if ((_o1_ instanceof ItemBuyCount.Const)) assign(((ItemBuyCount.Const)_o1_).nThis()); else {
/* 528 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ItemBuyCount _o_) {
/* 533 */       this.cleartime = _o_.cleartime;
/* 534 */       this.id2count = new HashMap();
/* 535 */       for (Map.Entry<Integer, Integer> _e_ : _o_.id2count.entrySet()) {
/* 536 */         this.id2count.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 541 */       this.cleartime = _o_.cleartime;
/* 542 */       this.id2count = new HashMap();
/* 543 */       for (Map.Entry<Integer, Integer> _e_ : _o_.id2count.entrySet()) {
/* 544 */         this.id2count.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 550 */       _os_.marshal(this.cleartime);
/* 551 */       _os_.compact_uint32(this.id2count.size());
/* 552 */       for (Map.Entry<Integer, Integer> _e_ : this.id2count.entrySet())
/*     */       {
/* 554 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 555 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 557 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 563 */       this.cleartime = _os_.unmarshal_long();
/*     */       
/* 565 */       int size = _os_.uncompact_uint32();
/* 566 */       if (size >= 12)
/*     */       {
/* 568 */         this.id2count = new HashMap(size * 2);
/*     */       }
/* 570 */       for (; size > 0; size--)
/*     */       {
/* 572 */         int _k_ = 0;
/* 573 */         _k_ = _os_.unmarshal_int();
/* 574 */         int _v_ = 0;
/* 575 */         _v_ = _os_.unmarshal_int();
/* 576 */         this.id2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 579 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 585 */       int _size_ = 0;
/* 586 */       _size_ += CodedOutputStream.computeInt64Size(1, this.cleartime);
/* 587 */       for (Map.Entry<Integer, Integer> _e_ : this.id2count.entrySet())
/*     */       {
/* 589 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 590 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         _output_.writeInt64(1, this.cleartime);
/* 601 */         for (Map.Entry<Integer, Integer> _e_ : this.id2count.entrySet())
/*     */         {
/* 603 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 604 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             this.cleartime = _input_.readInt64();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             int _k_ = 0;
/* 638 */             _k_ = _input_.readInt32();
/* 639 */             int readTag = _input_.readTag();
/* 640 */             if (16 != readTag)
/*     */             {
/* 642 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 644 */             int _v_ = 0;
/* 645 */             _v_ = _input_.readInt32();
/* 646 */             this.id2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 647 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 651 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 653 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 662 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 666 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 668 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ItemBuyCount copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ItemBuyCount toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ItemBuyCount toBean()
/*     */     {
/* 685 */       return new ItemBuyCount(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ItemBuyCount toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ItemBuyCount toBeanIf()
/*     */     {
/* 696 */       return new ItemBuyCount(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 718 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 722 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 726 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCleartime()
/*     */     {
/* 733 */       return this.cleartime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getId2count()
/*     */     {
/* 740 */       return this.id2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getId2countAsData()
/*     */     {
/* 747 */       return this.id2count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCleartime(long _v_)
/*     */     {
/* 754 */       this.cleartime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 760 */       if (!(_o1_ instanceof Data)) return false;
/* 761 */       Data _o_ = (Data)_o1_;
/* 762 */       if (this.cleartime != _o_.cleartime) return false;
/* 763 */       if (!this.id2count.equals(_o_.id2count)) return false;
/* 764 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 770 */       int _h_ = 0;
/* 771 */       _h_ = (int)(_h_ + this.cleartime);
/* 772 */       _h_ += this.id2count.hashCode();
/* 773 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 779 */       StringBuilder _sb_ = new StringBuilder();
/* 780 */       _sb_.append("(");
/* 781 */       _sb_.append(this.cleartime);
/* 782 */       _sb_.append(",");
/* 783 */       _sb_.append(this.id2count);
/* 784 */       _sb_.append(")");
/* 785 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ItemBuyCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */