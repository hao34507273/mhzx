/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class MysteryGoodsInfo extends XBean implements xbean.MysteryGoodsInfo
/*     */ {
/*     */   private int goods_id;
/*     */   private int sale;
/*     */   private int count;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.goods_id = 0;
/*  23 */     this.sale = 10000;
/*  24 */     this.count = 0;
/*     */   }
/*     */   
/*     */   MysteryGoodsInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.goods_id = 0;
/*  31 */     this.sale = 10000;
/*  32 */     this.count = 0;
/*     */   }
/*     */   
/*     */   public MysteryGoodsInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MysteryGoodsInfo(MysteryGoodsInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MysteryGoodsInfo(xbean.MysteryGoodsInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof MysteryGoodsInfo)) { assign((MysteryGoodsInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MysteryGoodsInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.goods_id = _o_.goods_id;
/*  58 */     this.sale = _o_.sale;
/*  59 */     this.count = _o_.count;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.goods_id = _o_.goods_id;
/*  65 */     this.sale = _o_.sale;
/*  66 */     this.count = _o_.count;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.goods_id);
/*  74 */     _os_.marshal(this.sale);
/*  75 */     _os_.marshal(this.count);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     this.goods_id = _os_.unmarshal_int();
/*  84 */     this.sale = _os_.unmarshal_int();
/*  85 */     this.count = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     int _size_ = 0;
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(1, this.goods_id);
/*  95 */     _size_ += CodedOutputStream.computeInt32Size(2, this.sale);
/*  96 */     _size_ += CodedOutputStream.computeInt32Size(3, this.count);
/*  97 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 106 */       _output_.writeInt32(1, this.goods_id);
/* 107 */       _output_.writeInt32(2, this.sale);
/* 108 */       _output_.writeInt32(3, this.count);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 112 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 114 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       boolean done = false;
/* 124 */       while (!done)
/*     */       {
/* 126 */         int tag = _input_.readTag();
/* 127 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 131 */           done = true;
/* 132 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 136 */           this.goods_id = _input_.readInt32();
/* 137 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 141 */           this.sale = _input_.readInt32();
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 146 */           this.count = _input_.readInt32();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 151 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 153 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 162 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 166 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 168 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MysteryGoodsInfo copy()
/*     */   {
/* 174 */     _xdb_verify_unsafe_();
/* 175 */     return new MysteryGoodsInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MysteryGoodsInfo toData()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MysteryGoodsInfo toBean()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new MysteryGoodsInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MysteryGoodsInfo toDataIf()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MysteryGoodsInfo toBeanIf()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getGoods_id()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this.goods_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSale()
/*     */   {
/* 223 */     _xdb_verify_unsafe_();
/* 224 */     return this.sale;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCount()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this.count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGoods_id(int _v_)
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     xdb.Logs.logIf(new LogKey(this, "goods_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 244 */         new LogInt(this, MysteryGoodsInfo.this.goods_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 248 */             MysteryGoodsInfo.this.goods_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 252 */     });
/* 253 */     this.goods_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSale(int _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "sale")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new LogInt(this, MysteryGoodsInfo.this.sale)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             MysteryGoodsInfo.this.sale = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.sale = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCount(int _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "count")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 286 */         new LogInt(this, MysteryGoodsInfo.this.count)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             MysteryGoodsInfo.this.count = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.count = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     MysteryGoodsInfo _o_ = null;
/* 303 */     if ((_o1_ instanceof MysteryGoodsInfo)) { _o_ = (MysteryGoodsInfo)_o1_;
/* 304 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 305 */       return false;
/* 306 */     if (this.goods_id != _o_.goods_id) return false;
/* 307 */     if (this.sale != _o_.sale) return false;
/* 308 */     if (this.count != _o_.count) return false;
/* 309 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     int _h_ = 0;
/* 317 */     _h_ += this.goods_id;
/* 318 */     _h_ += this.sale;
/* 319 */     _h_ += this.count;
/* 320 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 326 */     _xdb_verify_unsafe_();
/* 327 */     StringBuilder _sb_ = new StringBuilder();
/* 328 */     _sb_.append("(");
/* 329 */     _sb_.append(this.goods_id);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.sale);
/* 332 */     _sb_.append(",");
/* 333 */     _sb_.append(this.count);
/* 334 */     _sb_.append(")");
/* 335 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 341 */     ListenableBean lb = new ListenableBean();
/* 342 */     lb.add(new ListenableChanged().setVarName("goods_id"));
/* 343 */     lb.add(new ListenableChanged().setVarName("sale"));
/* 344 */     lb.add(new ListenableChanged().setVarName("count"));
/* 345 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MysteryGoodsInfo {
/*     */     private Const() {}
/*     */     
/*     */     MysteryGoodsInfo nThis() {
/* 352 */       return MysteryGoodsInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 358 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MysteryGoodsInfo copy()
/*     */     {
/* 364 */       return MysteryGoodsInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MysteryGoodsInfo toData()
/*     */     {
/* 370 */       return MysteryGoodsInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MysteryGoodsInfo toBean()
/*     */     {
/* 375 */       return MysteryGoodsInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MysteryGoodsInfo toDataIf()
/*     */     {
/* 381 */       return MysteryGoodsInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MysteryGoodsInfo toBeanIf()
/*     */     {
/* 386 */       return MysteryGoodsInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGoods_id()
/*     */     {
/* 393 */       MysteryGoodsInfo.this._xdb_verify_unsafe_();
/* 394 */       return MysteryGoodsInfo.this.goods_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSale()
/*     */     {
/* 401 */       MysteryGoodsInfo.this._xdb_verify_unsafe_();
/* 402 */       return MysteryGoodsInfo.this.sale;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCount()
/*     */     {
/* 409 */       MysteryGoodsInfo.this._xdb_verify_unsafe_();
/* 410 */       return MysteryGoodsInfo.this.count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGoods_id(int _v_)
/*     */     {
/* 417 */       MysteryGoodsInfo.this._xdb_verify_unsafe_();
/* 418 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSale(int _v_)
/*     */     {
/* 425 */       MysteryGoodsInfo.this._xdb_verify_unsafe_();
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCount(int _v_)
/*     */     {
/* 433 */       MysteryGoodsInfo.this._xdb_verify_unsafe_();
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 440 */       MysteryGoodsInfo.this._xdb_verify_unsafe_();
/* 441 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 447 */       MysteryGoodsInfo.this._xdb_verify_unsafe_();
/* 448 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 454 */       return MysteryGoodsInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 460 */       return MysteryGoodsInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 466 */       MysteryGoodsInfo.this._xdb_verify_unsafe_();
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 473 */       return MysteryGoodsInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 479 */       return MysteryGoodsInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 485 */       MysteryGoodsInfo.this._xdb_verify_unsafe_();
/* 486 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 492 */       return MysteryGoodsInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 498 */       return MysteryGoodsInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 504 */       return MysteryGoodsInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 510 */       return MysteryGoodsInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 516 */       return MysteryGoodsInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 522 */       return MysteryGoodsInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 528 */       return MysteryGoodsInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MysteryGoodsInfo
/*     */   {
/*     */     private int goods_id;
/*     */     
/*     */     private int sale;
/*     */     
/*     */     private int count;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 549 */       this.goods_id = 0;
/* 550 */       this.sale = 10000;
/* 551 */       this.count = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.MysteryGoodsInfo _o1_)
/*     */     {
/* 556 */       if ((_o1_ instanceof MysteryGoodsInfo)) { assign((MysteryGoodsInfo)_o1_);
/* 557 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 558 */       } else if ((_o1_ instanceof MysteryGoodsInfo.Const)) assign(((MysteryGoodsInfo.Const)_o1_).nThis()); else {
/* 559 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MysteryGoodsInfo _o_) {
/* 564 */       this.goods_id = _o_.goods_id;
/* 565 */       this.sale = _o_.sale;
/* 566 */       this.count = _o_.count;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 571 */       this.goods_id = _o_.goods_id;
/* 572 */       this.sale = _o_.sale;
/* 573 */       this.count = _o_.count;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 579 */       _os_.marshal(this.goods_id);
/* 580 */       _os_.marshal(this.sale);
/* 581 */       _os_.marshal(this.count);
/* 582 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 588 */       this.goods_id = _os_.unmarshal_int();
/* 589 */       this.sale = _os_.unmarshal_int();
/* 590 */       this.count = _os_.unmarshal_int();
/* 591 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 597 */       int _size_ = 0;
/* 598 */       _size_ += CodedOutputStream.computeInt32Size(1, this.goods_id);
/* 599 */       _size_ += CodedOutputStream.computeInt32Size(2, this.sale);
/* 600 */       _size_ += CodedOutputStream.computeInt32Size(3, this.count);
/* 601 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 609 */         _output_.writeInt32(1, this.goods_id);
/* 610 */         _output_.writeInt32(2, this.sale);
/* 611 */         _output_.writeInt32(3, this.count);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 615 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 617 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 625 */         boolean done = false;
/* 626 */         while (!done)
/*     */         {
/* 628 */           int tag = _input_.readTag();
/* 629 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 633 */             done = true;
/* 634 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 638 */             this.goods_id = _input_.readInt32();
/* 639 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 643 */             this.sale = _input_.readInt32();
/* 644 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 648 */             this.count = _input_.readInt32();
/* 649 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 653 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 655 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 664 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 668 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 670 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MysteryGoodsInfo copy()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MysteryGoodsInfo toData()
/*     */     {
/* 682 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MysteryGoodsInfo toBean()
/*     */     {
/* 687 */       return new MysteryGoodsInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MysteryGoodsInfo toDataIf()
/*     */     {
/* 693 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MysteryGoodsInfo toBeanIf()
/*     */     {
/* 698 */       return new MysteryGoodsInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 720 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 724 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 728 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGoods_id()
/*     */     {
/* 735 */       return this.goods_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSale()
/*     */     {
/* 742 */       return this.sale;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCount()
/*     */     {
/* 749 */       return this.count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGoods_id(int _v_)
/*     */     {
/* 756 */       this.goods_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSale(int _v_)
/*     */     {
/* 763 */       this.sale = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCount(int _v_)
/*     */     {
/* 770 */       this.count = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 776 */       if (!(_o1_ instanceof Data)) return false;
/* 777 */       Data _o_ = (Data)_o1_;
/* 778 */       if (this.goods_id != _o_.goods_id) return false;
/* 779 */       if (this.sale != _o_.sale) return false;
/* 780 */       if (this.count != _o_.count) return false;
/* 781 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 787 */       int _h_ = 0;
/* 788 */       _h_ += this.goods_id;
/* 789 */       _h_ += this.sale;
/* 790 */       _h_ += this.count;
/* 791 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 797 */       StringBuilder _sb_ = new StringBuilder();
/* 798 */       _sb_.append("(");
/* 799 */       _sb_.append(this.goods_id);
/* 800 */       _sb_.append(",");
/* 801 */       _sb_.append(this.sale);
/* 802 */       _sb_.append(",");
/* 803 */       _sb_.append(this.count);
/* 804 */       _sb_.append(")");
/* 805 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MysteryGoodsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */