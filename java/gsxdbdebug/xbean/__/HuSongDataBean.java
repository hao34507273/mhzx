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
/*     */ public final class HuSongDataBean extends XBean implements xbean.HuSongDataBean
/*     */ {
/*     */   private HashMap<Integer, Integer> parammap;
/*     */   private int specialcount;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.parammap.clear();
/*  21 */     this.specialcount = 0;
/*     */   }
/*     */   
/*     */   HuSongDataBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.parammap = new HashMap();
/*  28 */     this.specialcount = 0;
/*     */   }
/*     */   
/*     */   public HuSongDataBean()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public HuSongDataBean(HuSongDataBean _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   HuSongDataBean(xbean.HuSongDataBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof HuSongDataBean)) { assign((HuSongDataBean)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(HuSongDataBean _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.parammap = new HashMap();
/*  54 */     for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet())
/*  55 */       this.parammap.put(_e_.getKey(), _e_.getValue());
/*  56 */     this.specialcount = _o_.specialcount;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.parammap = new HashMap();
/*  62 */     for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet())
/*  63 */       this.parammap.put(_e_.getKey(), _e_.getValue());
/*  64 */     this.specialcount = _o_.specialcount;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.compact_uint32(this.parammap.size());
/*  72 */     for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  75 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  77 */     _os_.marshal(this.specialcount);
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*     */     
/*  86 */     int size = _os_.uncompact_uint32();
/*  87 */     if (size >= 12)
/*     */     {
/*  89 */       this.parammap = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       int _k_ = 0;
/*  94 */       _k_ = _os_.unmarshal_int();
/*  95 */       int _v_ = 0;
/*  96 */       _v_ = _os_.unmarshal_int();
/*  97 */       this.parammap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 100 */     this.specialcount = _os_.unmarshal_int();
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     int _size_ = 0;
/* 109 */     for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*     */     {
/* 111 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 112 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 114 */     _size_ += CodedOutputStream.computeInt32Size(2, this.specialcount);
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*     */       {
/* 126 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 127 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 129 */       _output_.writeInt32(2, this.specialcount);
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
/* 157 */           int _k_ = 0;
/* 158 */           _k_ = _input_.readInt32();
/* 159 */           int readTag = _input_.readTag();
/* 160 */           if (8 != readTag)
/*     */           {
/* 162 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 164 */           int _v_ = 0;
/* 165 */           _v_ = _input_.readInt32();
/* 166 */           this.parammap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 171 */           this.specialcount = _input_.readInt32();
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
/*     */   public xbean.HuSongDataBean copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new HuSongDataBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HuSongDataBean toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.HuSongDataBean toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new HuSongDataBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HuSongDataBean toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.HuSongDataBean toBeanIf()
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
/*     */   public Map<Integer, Integer> getParammap()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return xdb.Logs.logMap(new xdb.LogKey(this, "parammap"), this.parammap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getParammapAsData()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/*     */     
/* 250 */     HuSongDataBean _o_ = this;
/* 251 */     Map<Integer, Integer> parammap = new HashMap();
/* 252 */     for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet())
/* 253 */       parammap.put(_e_.getKey(), _e_.getValue());
/* 254 */     return parammap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSpecialcount()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.specialcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSpecialcount(int _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new xdb.LogKey(this, "specialcount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogInt(this, HuSongDataBean.this.specialcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             HuSongDataBean.this.specialcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.specialcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     HuSongDataBean _o_ = null;
/* 291 */     if ((_o1_ instanceof HuSongDataBean)) { _o_ = (HuSongDataBean)_o1_;
/* 292 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 293 */       return false;
/* 294 */     if (!this.parammap.equals(_o_.parammap)) return false;
/* 295 */     if (this.specialcount != _o_.specialcount) return false;
/* 296 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     int _h_ = 0;
/* 304 */     _h_ += this.parammap.hashCode();
/* 305 */     _h_ += this.specialcount;
/* 306 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     StringBuilder _sb_ = new StringBuilder();
/* 314 */     _sb_.append("(");
/* 315 */     _sb_.append(this.parammap);
/* 316 */     _sb_.append(",");
/* 317 */     _sb_.append(this.specialcount);
/* 318 */     _sb_.append(")");
/* 319 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 325 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("parammap"));
/* 327 */     lb.add(new xdb.logs.ListenableChanged().setVarName("specialcount"));
/* 328 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.HuSongDataBean {
/*     */     private Const() {}
/*     */     
/*     */     HuSongDataBean nThis() {
/* 335 */       return HuSongDataBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HuSongDataBean copy()
/*     */     {
/* 347 */       return HuSongDataBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HuSongDataBean toData()
/*     */     {
/* 353 */       return HuSongDataBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.HuSongDataBean toBean()
/*     */     {
/* 358 */       return HuSongDataBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HuSongDataBean toDataIf()
/*     */     {
/* 364 */       return HuSongDataBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.HuSongDataBean toBeanIf()
/*     */     {
/* 369 */       return HuSongDataBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getParammap()
/*     */     {
/* 376 */       HuSongDataBean.this._xdb_verify_unsafe_();
/* 377 */       return xdb.Consts.constMap(HuSongDataBean.this.parammap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getParammapAsData()
/*     */     {
/* 384 */       HuSongDataBean.this._xdb_verify_unsafe_();
/*     */       
/* 386 */       HuSongDataBean _o_ = HuSongDataBean.this;
/* 387 */       Map<Integer, Integer> parammap = new HashMap();
/* 388 */       for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet())
/* 389 */         parammap.put(_e_.getKey(), _e_.getValue());
/* 390 */       return parammap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSpecialcount()
/*     */     {
/* 397 */       HuSongDataBean.this._xdb_verify_unsafe_();
/* 398 */       return HuSongDataBean.this.specialcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSpecialcount(int _v_)
/*     */     {
/* 405 */       HuSongDataBean.this._xdb_verify_unsafe_();
/* 406 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 412 */       HuSongDataBean.this._xdb_verify_unsafe_();
/* 413 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 419 */       HuSongDataBean.this._xdb_verify_unsafe_();
/* 420 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 426 */       return HuSongDataBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 432 */       return HuSongDataBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 438 */       HuSongDataBean.this._xdb_verify_unsafe_();
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 445 */       return HuSongDataBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 451 */       return HuSongDataBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 457 */       HuSongDataBean.this._xdb_verify_unsafe_();
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 464 */       return HuSongDataBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 470 */       return HuSongDataBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 476 */       return HuSongDataBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 482 */       return HuSongDataBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 488 */       return HuSongDataBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 494 */       return HuSongDataBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 500 */       return HuSongDataBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.HuSongDataBean
/*     */   {
/*     */     private HashMap<Integer, Integer> parammap;
/*     */     
/*     */     private int specialcount;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 519 */       this.parammap = new HashMap();
/* 520 */       this.specialcount = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.HuSongDataBean _o1_)
/*     */     {
/* 525 */       if ((_o1_ instanceof HuSongDataBean)) { assign((HuSongDataBean)_o1_);
/* 526 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 527 */       } else if ((_o1_ instanceof HuSongDataBean.Const)) assign(((HuSongDataBean.Const)_o1_).nThis()); else {
/* 528 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(HuSongDataBean _o_) {
/* 533 */       this.parammap = new HashMap();
/* 534 */       for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet())
/* 535 */         this.parammap.put(_e_.getKey(), _e_.getValue());
/* 536 */       this.specialcount = _o_.specialcount;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 541 */       this.parammap = new HashMap();
/* 542 */       for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet())
/* 543 */         this.parammap.put(_e_.getKey(), _e_.getValue());
/* 544 */       this.specialcount = _o_.specialcount;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 550 */       _os_.compact_uint32(this.parammap.size());
/* 551 */       for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*     */       {
/* 553 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 554 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 556 */       _os_.marshal(this.specialcount);
/* 557 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 564 */       int size = _os_.uncompact_uint32();
/* 565 */       if (size >= 12)
/*     */       {
/* 567 */         this.parammap = new HashMap(size * 2);
/*     */       }
/* 569 */       for (; size > 0; size--)
/*     */       {
/* 571 */         int _k_ = 0;
/* 572 */         _k_ = _os_.unmarshal_int();
/* 573 */         int _v_ = 0;
/* 574 */         _v_ = _os_.unmarshal_int();
/* 575 */         this.parammap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 578 */       this.specialcount = _os_.unmarshal_int();
/* 579 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 585 */       int _size_ = 0;
/* 586 */       for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*     */       {
/* 588 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 589 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 591 */       _size_ += CodedOutputStream.computeInt32Size(2, this.specialcount);
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*     */         {
/* 602 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 603 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 605 */         _output_.writeInt32(2, this.specialcount);
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
/* 632 */             int _k_ = 0;
/* 633 */             _k_ = _input_.readInt32();
/* 634 */             int readTag = _input_.readTag();
/* 635 */             if (8 != readTag)
/*     */             {
/* 637 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 639 */             int _v_ = 0;
/* 640 */             _v_ = _input_.readInt32();
/* 641 */             this.parammap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 642 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 646 */             this.specialcount = _input_.readInt32();
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
/*     */     public xbean.HuSongDataBean copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HuSongDataBean toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.HuSongDataBean toBean()
/*     */     {
/* 685 */       return new HuSongDataBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HuSongDataBean toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.HuSongDataBean toBeanIf()
/*     */     {
/* 696 */       return new HuSongDataBean(this, null, null);
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
/*     */     public Map<Integer, Integer> getParammap()
/*     */     {
/* 733 */       return this.parammap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getParammapAsData()
/*     */     {
/* 740 */       return this.parammap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSpecialcount()
/*     */     {
/* 747 */       return this.specialcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSpecialcount(int _v_)
/*     */     {
/* 754 */       this.specialcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 760 */       if (!(_o1_ instanceof Data)) return false;
/* 761 */       Data _o_ = (Data)_o1_;
/* 762 */       if (!this.parammap.equals(_o_.parammap)) return false;
/* 763 */       if (this.specialcount != _o_.specialcount) return false;
/* 764 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 770 */       int _h_ = 0;
/* 771 */       _h_ += this.parammap.hashCode();
/* 772 */       _h_ += this.specialcount;
/* 773 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 779 */       StringBuilder _sb_ = new StringBuilder();
/* 780 */       _sb_.append("(");
/* 781 */       _sb_.append(this.parammap);
/* 782 */       _sb_.append(",");
/* 783 */       _sb_.append(this.specialcount);
/* 784 */       _sb_.append(")");
/* 785 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\HuSongDataBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */