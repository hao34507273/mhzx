/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class MarriageFriendInfo extends XBean implements xbean.MarriageFriendInfo
/*     */ {
/*     */   private int giftid;
/*     */   private boolean isnotified;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.giftid = 0;
/*  21 */     this.isnotified = false;
/*     */   }
/*     */   
/*     */   MarriageFriendInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public MarriageFriendInfo()
/*     */   {
/*  31 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MarriageFriendInfo(MarriageFriendInfo _o_)
/*     */   {
/*  36 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MarriageFriendInfo(xbean.MarriageFriendInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  41 */     super(_xp_, _vn_);
/*  42 */     if ((_o1_ instanceof MarriageFriendInfo)) { assign((MarriageFriendInfo)_o1_);
/*  43 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  44 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  45 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MarriageFriendInfo _o_) {
/*  50 */     _o_._xdb_verify_unsafe_();
/*  51 */     this.giftid = _o_.giftid;
/*  52 */     this.isnotified = _o_.isnotified;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  57 */     this.giftid = _o_.giftid;
/*  58 */     this.isnotified = _o_.isnotified;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.marshal(this.giftid);
/*  66 */     _os_.marshal(this.isnotified);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  73 */     _xdb_verify_unsafe_();
/*  74 */     this.giftid = _os_.unmarshal_int();
/*  75 */     this.isnotified = _os_.unmarshal_boolean();
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     int _size_ = 0;
/*  84 */     _size_ += CodedOutputStream.computeInt32Size(1, this.giftid);
/*  85 */     _size_ += CodedOutputStream.computeBoolSize(2, this.isnotified);
/*  86 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  95 */       _output_.writeInt32(1, this.giftid);
/*  96 */       _output_.writeBool(2, this.isnotified);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 100 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 102 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       boolean done = false;
/* 112 */       while (!done)
/*     */       {
/* 114 */         int tag = _input_.readTag();
/* 115 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 119 */           done = true;
/* 120 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 124 */           this.giftid = _input_.readInt32();
/* 125 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 129 */           this.isnotified = _input_.readBool();
/* 130 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 134 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 136 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 145 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 149 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 151 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarriageFriendInfo copy()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new MarriageFriendInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarriageFriendInfo toData()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MarriageFriendInfo toBean()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new MarriageFriendInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarriageFriendInfo toDataIf()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MarriageFriendInfo toBeanIf()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getGiftid()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this.giftid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIsnotified()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.isnotified;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGiftid(int _v_)
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     xdb.Logs.logIf(new LogKey(this, "giftid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 219 */         new xdb.logs.LogInt(this, MarriageFriendInfo.this.giftid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 223 */             MarriageFriendInfo.this.giftid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 227 */     });
/* 228 */     this.giftid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIsnotified(boolean _v_)
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     xdb.Logs.logIf(new LogKey(this, "isnotified")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 240 */         new xdb.logs.LogObject(this, Boolean.valueOf(MarriageFriendInfo.this.isnotified))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 244 */             MarriageFriendInfo.this.isnotified = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 248 */     });
/* 249 */     this.isnotified = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     MarriageFriendInfo _o_ = null;
/* 257 */     if ((_o1_ instanceof MarriageFriendInfo)) { _o_ = (MarriageFriendInfo)_o1_;
/* 258 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 259 */       return false;
/* 260 */     if (this.giftid != _o_.giftid) return false;
/* 261 */     if (this.isnotified != _o_.isnotified) return false;
/* 262 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     int _h_ = 0;
/* 270 */     _h_ += this.giftid;
/* 271 */     _h_ += (this.isnotified ? 1231 : 1237);
/* 272 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     StringBuilder _sb_ = new StringBuilder();
/* 280 */     _sb_.append("(");
/* 281 */     _sb_.append(this.giftid);
/* 282 */     _sb_.append(",");
/* 283 */     _sb_.append(this.isnotified);
/* 284 */     _sb_.append(")");
/* 285 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 291 */     ListenableBean lb = new ListenableBean();
/* 292 */     lb.add(new xdb.logs.ListenableChanged().setVarName("giftid"));
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("isnotified"));
/* 294 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MarriageFriendInfo {
/*     */     private Const() {}
/*     */     
/*     */     MarriageFriendInfo nThis() {
/* 301 */       return MarriageFriendInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 307 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarriageFriendInfo copy()
/*     */     {
/* 313 */       return MarriageFriendInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarriageFriendInfo toData()
/*     */     {
/* 319 */       return MarriageFriendInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MarriageFriendInfo toBean()
/*     */     {
/* 324 */       return MarriageFriendInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarriageFriendInfo toDataIf()
/*     */     {
/* 330 */       return MarriageFriendInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MarriageFriendInfo toBeanIf()
/*     */     {
/* 335 */       return MarriageFriendInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGiftid()
/*     */     {
/* 342 */       MarriageFriendInfo.this._xdb_verify_unsafe_();
/* 343 */       return MarriageFriendInfo.this.giftid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsnotified()
/*     */     {
/* 350 */       MarriageFriendInfo.this._xdb_verify_unsafe_();
/* 351 */       return MarriageFriendInfo.this.isnotified;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGiftid(int _v_)
/*     */     {
/* 358 */       MarriageFriendInfo.this._xdb_verify_unsafe_();
/* 359 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsnotified(boolean _v_)
/*     */     {
/* 366 */       MarriageFriendInfo.this._xdb_verify_unsafe_();
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 373 */       MarriageFriendInfo.this._xdb_verify_unsafe_();
/* 374 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 380 */       MarriageFriendInfo.this._xdb_verify_unsafe_();
/* 381 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 387 */       return MarriageFriendInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 393 */       return MarriageFriendInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 399 */       MarriageFriendInfo.this._xdb_verify_unsafe_();
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 406 */       return MarriageFriendInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 412 */       return MarriageFriendInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 418 */       MarriageFriendInfo.this._xdb_verify_unsafe_();
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 425 */       return MarriageFriendInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 431 */       return MarriageFriendInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 437 */       return MarriageFriendInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 443 */       return MarriageFriendInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 449 */       return MarriageFriendInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 455 */       return MarriageFriendInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 461 */       return MarriageFriendInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MarriageFriendInfo
/*     */   {
/*     */     private int giftid;
/*     */     
/*     */     private boolean isnotified;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 475 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.MarriageFriendInfo _o1_)
/*     */     {
/* 484 */       if ((_o1_ instanceof MarriageFriendInfo)) { assign((MarriageFriendInfo)_o1_);
/* 485 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 486 */       } else if ((_o1_ instanceof MarriageFriendInfo.Const)) assign(((MarriageFriendInfo.Const)_o1_).nThis()); else {
/* 487 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MarriageFriendInfo _o_) {
/* 492 */       this.giftid = _o_.giftid;
/* 493 */       this.isnotified = _o_.isnotified;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 498 */       this.giftid = _o_.giftid;
/* 499 */       this.isnotified = _o_.isnotified;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 505 */       _os_.marshal(this.giftid);
/* 506 */       _os_.marshal(this.isnotified);
/* 507 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 513 */       this.giftid = _os_.unmarshal_int();
/* 514 */       this.isnotified = _os_.unmarshal_boolean();
/* 515 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 521 */       int _size_ = 0;
/* 522 */       _size_ += CodedOutputStream.computeInt32Size(1, this.giftid);
/* 523 */       _size_ += CodedOutputStream.computeBoolSize(2, this.isnotified);
/* 524 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 532 */         _output_.writeInt32(1, this.giftid);
/* 533 */         _output_.writeBool(2, this.isnotified);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 537 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 539 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 547 */         boolean done = false;
/* 548 */         while (!done)
/*     */         {
/* 550 */           int tag = _input_.readTag();
/* 551 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 555 */             done = true;
/* 556 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 560 */             this.giftid = _input_.readInt32();
/* 561 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 565 */             this.isnotified = _input_.readBool();
/* 566 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 570 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 572 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 581 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 585 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 587 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarriageFriendInfo copy()
/*     */     {
/* 593 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarriageFriendInfo toData()
/*     */     {
/* 599 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MarriageFriendInfo toBean()
/*     */     {
/* 604 */       return new MarriageFriendInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarriageFriendInfo toDataIf()
/*     */     {
/* 610 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MarriageFriendInfo toBeanIf()
/*     */     {
/* 615 */       return new MarriageFriendInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 621 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 625 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 629 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 633 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 637 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 641 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 645 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGiftid()
/*     */     {
/* 652 */       return this.giftid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsnotified()
/*     */     {
/* 659 */       return this.isnotified;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGiftid(int _v_)
/*     */     {
/* 666 */       this.giftid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsnotified(boolean _v_)
/*     */     {
/* 673 */       this.isnotified = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 679 */       if (!(_o1_ instanceof Data)) return false;
/* 680 */       Data _o_ = (Data)_o1_;
/* 681 */       if (this.giftid != _o_.giftid) return false;
/* 682 */       if (this.isnotified != _o_.isnotified) return false;
/* 683 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 689 */       int _h_ = 0;
/* 690 */       _h_ += this.giftid;
/* 691 */       _h_ += (this.isnotified ? 1231 : 1237);
/* 692 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 698 */       StringBuilder _sb_ = new StringBuilder();
/* 699 */       _sb_.append("(");
/* 700 */       _sb_.append(this.giftid);
/* 701 */       _sb_.append(",");
/* 702 */       _sb_.append(this.isnotified);
/* 703 */       _sb_.append(")");
/* 704 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MarriageFriendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */