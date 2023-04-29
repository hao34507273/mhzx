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
/*     */ public final class HomeOwners extends XBean implements xbean.HomeOwners
/*     */ {
/*     */   private long creatorroleid;
/*     */   private long partnerroleid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.creatorroleid = 0L;
/*  21 */     this.partnerroleid = -1L;
/*     */   }
/*     */   
/*     */   HomeOwners(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.partnerroleid = -1L;
/*     */   }
/*     */   
/*     */   public HomeOwners()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public HomeOwners(HomeOwners _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   HomeOwners(xbean.HomeOwners _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof HomeOwners)) { assign((HomeOwners)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(HomeOwners _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.creatorroleid = _o_.creatorroleid;
/*  53 */     this.partnerroleid = _o_.partnerroleid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  58 */     this.creatorroleid = _o_.creatorroleid;
/*  59 */     this.partnerroleid = _o_.partnerroleid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  65 */     _xdb_verify_unsafe_();
/*  66 */     _os_.marshal(this.creatorroleid);
/*  67 */     _os_.marshal(this.partnerroleid);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     this.creatorroleid = _os_.unmarshal_long();
/*  76 */     this.partnerroleid = _os_.unmarshal_long();
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     int _size_ = 0;
/*  85 */     _size_ += CodedOutputStream.computeInt64Size(1, this.creatorroleid);
/*  86 */     _size_ += CodedOutputStream.computeInt64Size(2, this.partnerroleid);
/*  87 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  93 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  96 */       _output_.writeInt64(1, this.creatorroleid);
/*  97 */       _output_.writeInt64(2, this.partnerroleid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 101 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 103 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 112 */       boolean done = false;
/* 113 */       while (!done)
/*     */       {
/* 115 */         int tag = _input_.readTag();
/* 116 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 120 */           done = true;
/* 121 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 125 */           this.creatorroleid = _input_.readInt64();
/* 126 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 130 */           this.partnerroleid = _input_.readInt64();
/* 131 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 135 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 137 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 146 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 150 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 152 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HomeOwners copy()
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/* 159 */     return new HomeOwners(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HomeOwners toData()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.HomeOwners toBean()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new HomeOwners(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HomeOwners toDataIf()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.HomeOwners toBeanIf()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getCreatorroleid()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return this.creatorroleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getPartnerroleid()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return this.partnerroleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreatorroleid(long _v_)
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     xdb.Logs.logIf(new LogKey(this, "creatorroleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 220 */         new LogLong(this, HomeOwners.this.creatorroleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 224 */             HomeOwners.this.creatorroleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 228 */     });
/* 229 */     this.creatorroleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPartnerroleid(long _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "partnerroleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new LogLong(this, HomeOwners.this.partnerroleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             HomeOwners.this.partnerroleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.partnerroleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     HomeOwners _o_ = null;
/* 258 */     if ((_o1_ instanceof HomeOwners)) { _o_ = (HomeOwners)_o1_;
/* 259 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 260 */       return false;
/* 261 */     if (this.creatorroleid != _o_.creatorroleid) return false;
/* 262 */     if (this.partnerroleid != _o_.partnerroleid) return false;
/* 263 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     int _h_ = 0;
/* 271 */     _h_ = (int)(_h_ + this.creatorroleid);
/* 272 */     _h_ = (int)(_h_ + this.partnerroleid);
/* 273 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     StringBuilder _sb_ = new StringBuilder();
/* 281 */     _sb_.append("(");
/* 282 */     _sb_.append(this.creatorroleid);
/* 283 */     _sb_.append(",");
/* 284 */     _sb_.append(this.partnerroleid);
/* 285 */     _sb_.append(")");
/* 286 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 292 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("creatorroleid"));
/* 294 */     lb.add(new xdb.logs.ListenableChanged().setVarName("partnerroleid"));
/* 295 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.HomeOwners {
/*     */     private Const() {}
/*     */     
/*     */     HomeOwners nThis() {
/* 302 */       return HomeOwners.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 308 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HomeOwners copy()
/*     */     {
/* 314 */       return HomeOwners.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HomeOwners toData()
/*     */     {
/* 320 */       return HomeOwners.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.HomeOwners toBean()
/*     */     {
/* 325 */       return HomeOwners.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HomeOwners toDataIf()
/*     */     {
/* 331 */       return HomeOwners.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.HomeOwners toBeanIf()
/*     */     {
/* 336 */       return HomeOwners.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCreatorroleid()
/*     */     {
/* 343 */       HomeOwners.this._xdb_verify_unsafe_();
/* 344 */       return HomeOwners.this.creatorroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPartnerroleid()
/*     */     {
/* 351 */       HomeOwners.this._xdb_verify_unsafe_();
/* 352 */       return HomeOwners.this.partnerroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCreatorroleid(long _v_)
/*     */     {
/* 359 */       HomeOwners.this._xdb_verify_unsafe_();
/* 360 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPartnerroleid(long _v_)
/*     */     {
/* 367 */       HomeOwners.this._xdb_verify_unsafe_();
/* 368 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 374 */       HomeOwners.this._xdb_verify_unsafe_();
/* 375 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 381 */       HomeOwners.this._xdb_verify_unsafe_();
/* 382 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 388 */       return HomeOwners.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 394 */       return HomeOwners.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 400 */       HomeOwners.this._xdb_verify_unsafe_();
/* 401 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 407 */       return HomeOwners.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 413 */       return HomeOwners.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 419 */       HomeOwners.this._xdb_verify_unsafe_();
/* 420 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 426 */       return HomeOwners.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 432 */       return HomeOwners.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 438 */       return HomeOwners.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 444 */       return HomeOwners.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 450 */       return HomeOwners.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 456 */       return HomeOwners.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 462 */       return HomeOwners.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.HomeOwners
/*     */   {
/*     */     private long creatorroleid;
/*     */     
/*     */     private long partnerroleid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 481 */       this.partnerroleid = -1L;
/*     */     }
/*     */     
/*     */     Data(xbean.HomeOwners _o1_)
/*     */     {
/* 486 */       if ((_o1_ instanceof HomeOwners)) { assign((HomeOwners)_o1_);
/* 487 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 488 */       } else if ((_o1_ instanceof HomeOwners.Const)) assign(((HomeOwners.Const)_o1_).nThis()); else {
/* 489 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(HomeOwners _o_) {
/* 494 */       this.creatorroleid = _o_.creatorroleid;
/* 495 */       this.partnerroleid = _o_.partnerroleid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 500 */       this.creatorroleid = _o_.creatorroleid;
/* 501 */       this.partnerroleid = _o_.partnerroleid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 507 */       _os_.marshal(this.creatorroleid);
/* 508 */       _os_.marshal(this.partnerroleid);
/* 509 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 515 */       this.creatorroleid = _os_.unmarshal_long();
/* 516 */       this.partnerroleid = _os_.unmarshal_long();
/* 517 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 523 */       int _size_ = 0;
/* 524 */       _size_ += CodedOutputStream.computeInt64Size(1, this.creatorroleid);
/* 525 */       _size_ += CodedOutputStream.computeInt64Size(2, this.partnerroleid);
/* 526 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 534 */         _output_.writeInt64(1, this.creatorroleid);
/* 535 */         _output_.writeInt64(2, this.partnerroleid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 539 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 541 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 549 */         boolean done = false;
/* 550 */         while (!done)
/*     */         {
/* 552 */           int tag = _input_.readTag();
/* 553 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 557 */             done = true;
/* 558 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 562 */             this.creatorroleid = _input_.readInt64();
/* 563 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 567 */             this.partnerroleid = _input_.readInt64();
/* 568 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 572 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 574 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 583 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 587 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 589 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HomeOwners copy()
/*     */     {
/* 595 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HomeOwners toData()
/*     */     {
/* 601 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.HomeOwners toBean()
/*     */     {
/* 606 */       return new HomeOwners(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HomeOwners toDataIf()
/*     */     {
/* 612 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.HomeOwners toBeanIf()
/*     */     {
/* 617 */       return new HomeOwners(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 627 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 631 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 635 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 639 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 643 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 647 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCreatorroleid()
/*     */     {
/* 654 */       return this.creatorroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPartnerroleid()
/*     */     {
/* 661 */       return this.partnerroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCreatorroleid(long _v_)
/*     */     {
/* 668 */       this.creatorroleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPartnerroleid(long _v_)
/*     */     {
/* 675 */       this.partnerroleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 681 */       if (!(_o1_ instanceof Data)) return false;
/* 682 */       Data _o_ = (Data)_o1_;
/* 683 */       if (this.creatorroleid != _o_.creatorroleid) return false;
/* 684 */       if (this.partnerroleid != _o_.partnerroleid) return false;
/* 685 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 691 */       int _h_ = 0;
/* 692 */       _h_ = (int)(_h_ + this.creatorroleid);
/* 693 */       _h_ = (int)(_h_ + this.partnerroleid);
/* 694 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 700 */       StringBuilder _sb_ = new StringBuilder();
/* 701 */       _sb_.append("(");
/* 702 */       _sb_.append(this.creatorroleid);
/* 703 */       _sb_.append(",");
/* 704 */       _sb_.append(this.partnerroleid);
/* 705 */       _sb_.append(")");
/* 706 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\HomeOwners.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */