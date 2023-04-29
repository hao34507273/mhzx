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
/*     */ public final class Reason2Resource extends XBean implements xbean.Reason2Resource
/*     */ {
/*     */   private HashMap<Integer, xbean.ResourceId2Num> reason2item;
/*     */   private long itemupdatetime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.reason2item.clear();
/*  21 */     this.itemupdatetime = 0L;
/*     */   }
/*     */   
/*     */   Reason2Resource(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.reason2item = new HashMap();
/*     */   }
/*     */   
/*     */   public Reason2Resource()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Reason2Resource(Reason2Resource _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Reason2Resource(xbean.Reason2Resource _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof Reason2Resource)) { assign((Reason2Resource)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Reason2Resource _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.reason2item = new HashMap();
/*  53 */     for (Map.Entry<Integer, xbean.ResourceId2Num> _e_ : _o_.reason2item.entrySet())
/*  54 */       this.reason2item.put(_e_.getKey(), new ResourceId2Num((xbean.ResourceId2Num)_e_.getValue(), this, "reason2item"));
/*  55 */     this.itemupdatetime = _o_.itemupdatetime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  60 */     this.reason2item = new HashMap();
/*  61 */     for (Map.Entry<Integer, xbean.ResourceId2Num> _e_ : _o_.reason2item.entrySet())
/*  62 */       this.reason2item.put(_e_.getKey(), new ResourceId2Num((xbean.ResourceId2Num)_e_.getValue(), this, "reason2item"));
/*  63 */     this.itemupdatetime = _o_.itemupdatetime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.compact_uint32(this.reason2item.size());
/*  71 */     for (Map.Entry<Integer, xbean.ResourceId2Num> _e_ : this.reason2item.entrySet())
/*     */     {
/*  73 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  74 */       ((xbean.ResourceId2Num)_e_.getValue()).marshal(_os_);
/*     */     }
/*  76 */     _os_.marshal(this.itemupdatetime);
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*     */     
/*  85 */     int size = _os_.uncompact_uint32();
/*  86 */     if (size >= 12)
/*     */     {
/*  88 */       this.reason2item = new HashMap(size * 2);
/*     */     }
/*  90 */     for (; size > 0; size--)
/*     */     {
/*  92 */       int _k_ = 0;
/*  93 */       _k_ = _os_.unmarshal_int();
/*  94 */       xbean.ResourceId2Num _v_ = new ResourceId2Num(0, this, "reason2item");
/*  95 */       _v_.unmarshal(_os_);
/*  96 */       this.reason2item.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*  99 */     this.itemupdatetime = _os_.unmarshal_long();
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     int _size_ = 0;
/* 108 */     for (Map.Entry<Integer, xbean.ResourceId2Num> _e_ : this.reason2item.entrySet())
/*     */     {
/* 110 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 111 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 113 */     _size_ += CodedOutputStream.computeInt64Size(2, this.itemupdatetime);
/* 114 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       for (Map.Entry<Integer, xbean.ResourceId2Num> _e_ : this.reason2item.entrySet())
/*     */       {
/* 125 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 126 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 128 */       _output_.writeInt64(2, this.itemupdatetime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 132 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 134 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 143 */       boolean done = false;
/* 144 */       while (!done)
/*     */       {
/* 146 */         int tag = _input_.readTag();
/* 147 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 151 */           done = true;
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 156 */           int _k_ = 0;
/* 157 */           _k_ = _input_.readInt32();
/* 158 */           int readTag = _input_.readTag();
/* 159 */           if (10 != readTag)
/*     */           {
/* 161 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 163 */           xbean.ResourceId2Num _v_ = new ResourceId2Num(0, this, "reason2item");
/* 164 */           _input_.readMessage(_v_);
/* 165 */           this.reason2item.put(Integer.valueOf(_k_), _v_);
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 170 */           this.itemupdatetime = _input_.readInt64();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 175 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 177 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 186 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 190 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 192 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Reason2Resource copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Reason2Resource(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Reason2Resource toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Reason2Resource toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Reason2Resource(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Reason2Resource toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Reason2Resource toBeanIf()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.ResourceId2Num> getReason2item()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return xdb.Logs.logMap(new xdb.LogKey(this, "reason2item"), this.reason2item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.ResourceId2Num> getReason2itemAsData()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/*     */     
/* 249 */     Reason2Resource _o_ = this;
/* 250 */     Map<Integer, xbean.ResourceId2Num> reason2item = new HashMap();
/* 251 */     for (Map.Entry<Integer, xbean.ResourceId2Num> _e_ : _o_.reason2item.entrySet())
/* 252 */       reason2item.put(_e_.getKey(), new ResourceId2Num.Data((xbean.ResourceId2Num)_e_.getValue()));
/* 253 */     return reason2item;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getItemupdatetime()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return this.itemupdatetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setItemupdatetime(long _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "itemupdatetime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogLong(this, Reason2Resource.this.itemupdatetime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             Reason2Resource.this.itemupdatetime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.itemupdatetime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     Reason2Resource _o_ = null;
/* 290 */     if ((_o1_ instanceof Reason2Resource)) { _o_ = (Reason2Resource)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (!this.reason2item.equals(_o_.reason2item)) return false;
/* 294 */     if (this.itemupdatetime != _o_.itemupdatetime) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ += this.reason2item.hashCode();
/* 304 */     _h_ = (int)(_h_ + this.itemupdatetime);
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.reason2item);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.itemupdatetime);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableMap().setVarName("reason2item"));
/* 326 */     lb.add(new xdb.logs.ListenableChanged().setVarName("itemupdatetime"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Reason2Resource {
/*     */     private Const() {}
/*     */     
/*     */     Reason2Resource nThis() {
/* 334 */       return Reason2Resource.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Reason2Resource copy()
/*     */     {
/* 346 */       return Reason2Resource.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Reason2Resource toData()
/*     */     {
/* 352 */       return Reason2Resource.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Reason2Resource toBean()
/*     */     {
/* 357 */       return Reason2Resource.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Reason2Resource toDataIf()
/*     */     {
/* 363 */       return Reason2Resource.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Reason2Resource toBeanIf()
/*     */     {
/* 368 */       return Reason2Resource.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.ResourceId2Num> getReason2item()
/*     */     {
/* 375 */       Reason2Resource.this._xdb_verify_unsafe_();
/* 376 */       return xdb.Consts.constMap(Reason2Resource.this.reason2item);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.ResourceId2Num> getReason2itemAsData()
/*     */     {
/* 383 */       Reason2Resource.this._xdb_verify_unsafe_();
/*     */       
/* 385 */       Reason2Resource _o_ = Reason2Resource.this;
/* 386 */       Map<Integer, xbean.ResourceId2Num> reason2item = new HashMap();
/* 387 */       for (Map.Entry<Integer, xbean.ResourceId2Num> _e_ : _o_.reason2item.entrySet())
/* 388 */         reason2item.put(_e_.getKey(), new ResourceId2Num.Data((xbean.ResourceId2Num)_e_.getValue()));
/* 389 */       return reason2item;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getItemupdatetime()
/*     */     {
/* 396 */       Reason2Resource.this._xdb_verify_unsafe_();
/* 397 */       return Reason2Resource.this.itemupdatetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setItemupdatetime(long _v_)
/*     */     {
/* 404 */       Reason2Resource.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       Reason2Resource.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       Reason2Resource.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return Reason2Resource.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return Reason2Resource.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       Reason2Resource.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return Reason2Resource.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return Reason2Resource.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       Reason2Resource.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return Reason2Resource.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return Reason2Resource.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return Reason2Resource.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return Reason2Resource.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return Reason2Resource.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return Reason2Resource.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return Reason2Resource.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Reason2Resource
/*     */   {
/*     */     private HashMap<Integer, xbean.ResourceId2Num> reason2item;
/*     */     
/*     */     private long itemupdatetime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.reason2item = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.Reason2Resource _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof Reason2Resource)) { assign((Reason2Resource)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof Reason2Resource.Const)) assign(((Reason2Resource.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Reason2Resource _o_) {
/* 531 */       this.reason2item = new HashMap();
/* 532 */       for (Map.Entry<Integer, xbean.ResourceId2Num> _e_ : _o_.reason2item.entrySet())
/* 533 */         this.reason2item.put(_e_.getKey(), new ResourceId2Num.Data((xbean.ResourceId2Num)_e_.getValue()));
/* 534 */       this.itemupdatetime = _o_.itemupdatetime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 539 */       this.reason2item = new HashMap();
/* 540 */       for (Map.Entry<Integer, xbean.ResourceId2Num> _e_ : _o_.reason2item.entrySet())
/* 541 */         this.reason2item.put(_e_.getKey(), new ResourceId2Num.Data((xbean.ResourceId2Num)_e_.getValue()));
/* 542 */       this.itemupdatetime = _o_.itemupdatetime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.compact_uint32(this.reason2item.size());
/* 549 */       for (Map.Entry<Integer, xbean.ResourceId2Num> _e_ : this.reason2item.entrySet())
/*     */       {
/* 551 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 552 */         ((xbean.ResourceId2Num)_e_.getValue()).marshal(_os_);
/*     */       }
/* 554 */       _os_.marshal(this.itemupdatetime);
/* 555 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 562 */       int size = _os_.uncompact_uint32();
/* 563 */       if (size >= 12)
/*     */       {
/* 565 */         this.reason2item = new HashMap(size * 2);
/*     */       }
/* 567 */       for (; size > 0; size--)
/*     */       {
/* 569 */         int _k_ = 0;
/* 570 */         _k_ = _os_.unmarshal_int();
/* 571 */         xbean.ResourceId2Num _v_ = xbean.Pod.newResourceId2NumData();
/* 572 */         _v_.unmarshal(_os_);
/* 573 */         this.reason2item.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 576 */       this.itemupdatetime = _os_.unmarshal_long();
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       for (Map.Entry<Integer, xbean.ResourceId2Num> _e_ : this.reason2item.entrySet())
/*     */       {
/* 586 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 587 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 589 */       _size_ += CodedOutputStream.computeInt64Size(2, this.itemupdatetime);
/* 590 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 598 */         for (Map.Entry<Integer, xbean.ResourceId2Num> _e_ : this.reason2item.entrySet())
/*     */         {
/* 600 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 601 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 603 */         _output_.writeInt64(2, this.itemupdatetime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 607 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 609 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 617 */         boolean done = false;
/* 618 */         while (!done)
/*     */         {
/* 620 */           int tag = _input_.readTag();
/* 621 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 625 */             done = true;
/* 626 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 630 */             int _k_ = 0;
/* 631 */             _k_ = _input_.readInt32();
/* 632 */             int readTag = _input_.readTag();
/* 633 */             if (10 != readTag)
/*     */             {
/* 635 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 637 */             xbean.ResourceId2Num _v_ = xbean.Pod.newResourceId2NumData();
/* 638 */             _input_.readMessage(_v_);
/* 639 */             this.reason2item.put(Integer.valueOf(_k_), _v_);
/* 640 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 644 */             this.itemupdatetime = _input_.readInt64();
/* 645 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 651 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 660 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 666 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Reason2Resource copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Reason2Resource toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Reason2Resource toBean()
/*     */     {
/* 683 */       return new Reason2Resource(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Reason2Resource toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Reason2Resource toBeanIf()
/*     */     {
/* 694 */       return new Reason2Resource(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 720 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.ResourceId2Num> getReason2item()
/*     */     {
/* 731 */       return this.reason2item;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.ResourceId2Num> getReason2itemAsData()
/*     */     {
/* 738 */       return this.reason2item;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getItemupdatetime()
/*     */     {
/* 745 */       return this.itemupdatetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setItemupdatetime(long _v_)
/*     */     {
/* 752 */       this.itemupdatetime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (!this.reason2item.equals(_o_.reason2item)) return false;
/* 761 */       if (this.itemupdatetime != _o_.itemupdatetime) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ += this.reason2item.hashCode();
/* 770 */       _h_ = (int)(_h_ + this.itemupdatetime);
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.reason2item);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.itemupdatetime);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Reason2Resource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */