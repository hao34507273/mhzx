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
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class CoupleRide extends XBean implements xbean.CoupleRide
/*     */ {
/*     */   private long rolea;
/*     */   private long roleb;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.rolea = 0L;
/*  21 */     this.roleb = 0L;
/*     */   }
/*     */   
/*     */   CoupleRide(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public CoupleRide()
/*     */   {
/*  31 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CoupleRide(CoupleRide _o_)
/*     */   {
/*  36 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CoupleRide(xbean.CoupleRide _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  41 */     super(_xp_, _vn_);
/*  42 */     if ((_o1_ instanceof CoupleRide)) { assign((CoupleRide)_o1_);
/*  43 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  44 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  45 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CoupleRide _o_) {
/*  50 */     _o_._xdb_verify_unsafe_();
/*  51 */     this.rolea = _o_.rolea;
/*  52 */     this.roleb = _o_.roleb;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  57 */     this.rolea = _o_.rolea;
/*  58 */     this.roleb = _o_.roleb;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.marshal(this.rolea);
/*  66 */     _os_.marshal(this.roleb);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  73 */     _xdb_verify_unsafe_();
/*  74 */     this.rolea = _os_.unmarshal_long();
/*  75 */     this.roleb = _os_.unmarshal_long();
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     int _size_ = 0;
/*  84 */     _size_ += CodedOutputStream.computeInt64Size(1, this.rolea);
/*  85 */     _size_ += CodedOutputStream.computeInt64Size(2, this.roleb);
/*  86 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  95 */       _output_.writeInt64(1, this.rolea);
/*  96 */       _output_.writeInt64(2, this.roleb);
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
/* 124 */           this.rolea = _input_.readInt64();
/* 125 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 129 */           this.roleb = _input_.readInt64();
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
/*     */   public xbean.CoupleRide copy()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new CoupleRide(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CoupleRide toData()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CoupleRide toBean()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new CoupleRide(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CoupleRide toDataIf()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CoupleRide toBeanIf()
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
/*     */   public long getRolea()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this.rolea;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleb()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.roleb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRolea(long _v_)
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     xdb.Logs.logIf(new LogKey(this, "rolea")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 219 */         new LogLong(this, CoupleRide.this.rolea)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 223 */             CoupleRide.this.rolea = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 227 */     });
/* 228 */     this.rolea = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleb(long _v_)
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     xdb.Logs.logIf(new LogKey(this, "roleb")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 240 */         new LogLong(this, CoupleRide.this.roleb)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 244 */             CoupleRide.this.roleb = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 248 */     });
/* 249 */     this.roleb = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     CoupleRide _o_ = null;
/* 257 */     if ((_o1_ instanceof CoupleRide)) { _o_ = (CoupleRide)_o1_;
/* 258 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 259 */       return false;
/* 260 */     if (this.rolea != _o_.rolea) return false;
/* 261 */     if (this.roleb != _o_.roleb) return false;
/* 262 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     int _h_ = 0;
/* 270 */     _h_ = (int)(_h_ + this.rolea);
/* 271 */     _h_ = (int)(_h_ + this.roleb);
/* 272 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     StringBuilder _sb_ = new StringBuilder();
/* 280 */     _sb_.append("(");
/* 281 */     _sb_.append(this.rolea);
/* 282 */     _sb_.append(",");
/* 283 */     _sb_.append(this.roleb);
/* 284 */     _sb_.append(")");
/* 285 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 291 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 292 */     lb.add(new xdb.logs.ListenableChanged().setVarName("rolea"));
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("roleb"));
/* 294 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CoupleRide {
/*     */     private Const() {}
/*     */     
/*     */     CoupleRide nThis() {
/* 301 */       return CoupleRide.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 307 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CoupleRide copy()
/*     */     {
/* 313 */       return CoupleRide.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CoupleRide toData()
/*     */     {
/* 319 */       return CoupleRide.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CoupleRide toBean()
/*     */     {
/* 324 */       return CoupleRide.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CoupleRide toDataIf()
/*     */     {
/* 330 */       return CoupleRide.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CoupleRide toBeanIf()
/*     */     {
/* 335 */       return CoupleRide.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRolea()
/*     */     {
/* 342 */       CoupleRide.this._xdb_verify_unsafe_();
/* 343 */       return CoupleRide.this.rolea;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleb()
/*     */     {
/* 350 */       CoupleRide.this._xdb_verify_unsafe_();
/* 351 */       return CoupleRide.this.roleb;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRolea(long _v_)
/*     */     {
/* 358 */       CoupleRide.this._xdb_verify_unsafe_();
/* 359 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleb(long _v_)
/*     */     {
/* 366 */       CoupleRide.this._xdb_verify_unsafe_();
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 373 */       CoupleRide.this._xdb_verify_unsafe_();
/* 374 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 380 */       CoupleRide.this._xdb_verify_unsafe_();
/* 381 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 387 */       return CoupleRide.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 393 */       return CoupleRide.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 399 */       CoupleRide.this._xdb_verify_unsafe_();
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 406 */       return CoupleRide.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 412 */       return CoupleRide.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 418 */       CoupleRide.this._xdb_verify_unsafe_();
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 425 */       return CoupleRide.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 431 */       return CoupleRide.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 437 */       return CoupleRide.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 443 */       return CoupleRide.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 449 */       return CoupleRide.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 455 */       return CoupleRide.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 461 */       return CoupleRide.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CoupleRide
/*     */   {
/*     */     private long rolea;
/*     */     
/*     */     private long roleb;
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
/*     */     Data(xbean.CoupleRide _o1_)
/*     */     {
/* 484 */       if ((_o1_ instanceof CoupleRide)) { assign((CoupleRide)_o1_);
/* 485 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 486 */       } else if ((_o1_ instanceof CoupleRide.Const)) assign(((CoupleRide.Const)_o1_).nThis()); else {
/* 487 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CoupleRide _o_) {
/* 492 */       this.rolea = _o_.rolea;
/* 493 */       this.roleb = _o_.roleb;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 498 */       this.rolea = _o_.rolea;
/* 499 */       this.roleb = _o_.roleb;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 505 */       _os_.marshal(this.rolea);
/* 506 */       _os_.marshal(this.roleb);
/* 507 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 513 */       this.rolea = _os_.unmarshal_long();
/* 514 */       this.roleb = _os_.unmarshal_long();
/* 515 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 521 */       int _size_ = 0;
/* 522 */       _size_ += CodedOutputStream.computeInt64Size(1, this.rolea);
/* 523 */       _size_ += CodedOutputStream.computeInt64Size(2, this.roleb);
/* 524 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 532 */         _output_.writeInt64(1, this.rolea);
/* 533 */         _output_.writeInt64(2, this.roleb);
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
/* 560 */             this.rolea = _input_.readInt64();
/* 561 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 565 */             this.roleb = _input_.readInt64();
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
/*     */     public xbean.CoupleRide copy()
/*     */     {
/* 593 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CoupleRide toData()
/*     */     {
/* 599 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CoupleRide toBean()
/*     */     {
/* 604 */       return new CoupleRide(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CoupleRide toDataIf()
/*     */     {
/* 610 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CoupleRide toBeanIf()
/*     */     {
/* 615 */       return new CoupleRide(this, null, null);
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
/*     */     public long getRolea()
/*     */     {
/* 652 */       return this.rolea;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleb()
/*     */     {
/* 659 */       return this.roleb;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRolea(long _v_)
/*     */     {
/* 666 */       this.rolea = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleb(long _v_)
/*     */     {
/* 673 */       this.roleb = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 679 */       if (!(_o1_ instanceof Data)) return false;
/* 680 */       Data _o_ = (Data)_o1_;
/* 681 */       if (this.rolea != _o_.rolea) return false;
/* 682 */       if (this.roleb != _o_.roleb) return false;
/* 683 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 689 */       int _h_ = 0;
/* 690 */       _h_ = (int)(_h_ + this.rolea);
/* 691 */       _h_ = (int)(_h_ + this.roleb);
/* 692 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 698 */       StringBuilder _sb_ = new StringBuilder();
/* 699 */       _sb_.append("(");
/* 700 */       _sb_.append(this.rolea);
/* 701 */       _sb_.append(",");
/* 702 */       _sb_.append(this.roleb);
/* 703 */       _sb_.append(")");
/* 704 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CoupleRide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */