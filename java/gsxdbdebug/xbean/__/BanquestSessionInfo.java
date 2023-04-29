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
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class BanquestSessionInfo extends XBean implements xbean.BanquestSessionInfo
/*     */ {
/*     */   private long banquestendsessionid;
/*     */   private long banquestsessionid;
/*     */   private long clearcontrollersessionid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.banquestendsessionid = 0L;
/*  23 */     this.banquestsessionid = 0L;
/*  24 */     this.clearcontrollersessionid = 0L;
/*     */   }
/*     */   
/*     */   BanquestSessionInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public BanquestSessionInfo()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public BanquestSessionInfo(BanquestSessionInfo _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   BanquestSessionInfo(xbean.BanquestSessionInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof BanquestSessionInfo)) { assign((BanquestSessionInfo)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(BanquestSessionInfo _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.banquestendsessionid = _o_.banquestendsessionid;
/*  55 */     this.banquestsessionid = _o_.banquestsessionid;
/*  56 */     this.clearcontrollersessionid = _o_.clearcontrollersessionid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.banquestendsessionid = _o_.banquestendsessionid;
/*  62 */     this.banquestsessionid = _o_.banquestsessionid;
/*  63 */     this.clearcontrollersessionid = _o_.clearcontrollersessionid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.banquestendsessionid);
/*  71 */     _os_.marshal(this.banquestsessionid);
/*  72 */     _os_.marshal(this.clearcontrollersessionid);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.banquestendsessionid = _os_.unmarshal_long();
/*  81 */     this.banquestsessionid = _os_.unmarshal_long();
/*  82 */     this.clearcontrollersessionid = _os_.unmarshal_long();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt64Size(1, this.banquestendsessionid);
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(2, this.banquestsessionid);
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(3, this.clearcontrollersessionid);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt64(1, this.banquestendsessionid);
/* 104 */       _output_.writeInt64(2, this.banquestsessionid);
/* 105 */       _output_.writeInt64(3, this.clearcontrollersessionid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 109 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 111 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       boolean done = false;
/* 121 */       while (!done)
/*     */       {
/* 123 */         int tag = _input_.readTag();
/* 124 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 128 */           done = true;
/* 129 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 133 */           this.banquestendsessionid = _input_.readInt64();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.banquestsessionid = _input_.readInt64();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.clearcontrollersessionid = _input_.readInt64();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 148 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 150 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 159 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 165 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BanquestSessionInfo copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new BanquestSessionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BanquestSessionInfo toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.BanquestSessionInfo toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new BanquestSessionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BanquestSessionInfo toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.BanquestSessionInfo toBeanIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getBanquestendsessionid()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.banquestendsessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getBanquestsessionid()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.banquestsessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getClearcontrollersessionid()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.clearcontrollersessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBanquestendsessionid(long _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "banquestendsessionid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new LogLong(this, BanquestSessionInfo.this.banquestendsessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             BanquestSessionInfo.this.banquestendsessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.banquestendsessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBanquestsessionid(long _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "banquestsessionid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new LogLong(this, BanquestSessionInfo.this.banquestsessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             BanquestSessionInfo.this.banquestsessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.banquestsessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setClearcontrollersessionid(long _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "clearcontrollersessionid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new LogLong(this, BanquestSessionInfo.this.clearcontrollersessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             BanquestSessionInfo.this.clearcontrollersessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.clearcontrollersessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     BanquestSessionInfo _o_ = null;
/* 300 */     if ((_o1_ instanceof BanquestSessionInfo)) { _o_ = (BanquestSessionInfo)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.banquestendsessionid != _o_.banquestendsessionid) return false;
/* 304 */     if (this.banquestsessionid != _o_.banquestsessionid) return false;
/* 305 */     if (this.clearcontrollersessionid != _o_.clearcontrollersessionid) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ = (int)(_h_ + this.banquestendsessionid);
/* 315 */     _h_ = (int)(_h_ + this.banquestsessionid);
/* 316 */     _h_ = (int)(_h_ + this.clearcontrollersessionid);
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.banquestendsessionid);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.banquestsessionid);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.clearcontrollersessionid);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("banquestendsessionid"));
/* 340 */     lb.add(new ListenableChanged().setVarName("banquestsessionid"));
/* 341 */     lb.add(new ListenableChanged().setVarName("clearcontrollersessionid"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.BanquestSessionInfo {
/*     */     private Const() {}
/*     */     
/*     */     BanquestSessionInfo nThis() {
/* 349 */       return BanquestSessionInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BanquestSessionInfo copy()
/*     */     {
/* 361 */       return BanquestSessionInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BanquestSessionInfo toData()
/*     */     {
/* 367 */       return BanquestSessionInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.BanquestSessionInfo toBean()
/*     */     {
/* 372 */       return BanquestSessionInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BanquestSessionInfo toDataIf()
/*     */     {
/* 378 */       return BanquestSessionInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.BanquestSessionInfo toBeanIf()
/*     */     {
/* 383 */       return BanquestSessionInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getBanquestendsessionid()
/*     */     {
/* 390 */       BanquestSessionInfo.this._xdb_verify_unsafe_();
/* 391 */       return BanquestSessionInfo.this.banquestendsessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getBanquestsessionid()
/*     */     {
/* 398 */       BanquestSessionInfo.this._xdb_verify_unsafe_();
/* 399 */       return BanquestSessionInfo.this.banquestsessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getClearcontrollersessionid()
/*     */     {
/* 406 */       BanquestSessionInfo.this._xdb_verify_unsafe_();
/* 407 */       return BanquestSessionInfo.this.clearcontrollersessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBanquestendsessionid(long _v_)
/*     */     {
/* 414 */       BanquestSessionInfo.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBanquestsessionid(long _v_)
/*     */     {
/* 422 */       BanquestSessionInfo.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setClearcontrollersessionid(long _v_)
/*     */     {
/* 430 */       BanquestSessionInfo.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 437 */       BanquestSessionInfo.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       BanquestSessionInfo.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return BanquestSessionInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return BanquestSessionInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       BanquestSessionInfo.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return BanquestSessionInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return BanquestSessionInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       BanquestSessionInfo.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 489 */       return BanquestSessionInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return BanquestSessionInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return BanquestSessionInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return BanquestSessionInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return BanquestSessionInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return BanquestSessionInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return BanquestSessionInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.BanquestSessionInfo
/*     */   {
/*     */     private long banquestendsessionid;
/*     */     
/*     */     private long banquestsessionid;
/*     */     
/*     */     private long clearcontrollersessionid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.BanquestSessionInfo _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof BanquestSessionInfo)) { assign((BanquestSessionInfo)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof BanquestSessionInfo.Const)) assign(((BanquestSessionInfo.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(BanquestSessionInfo _o_) {
/* 558 */       this.banquestendsessionid = _o_.banquestendsessionid;
/* 559 */       this.banquestsessionid = _o_.banquestsessionid;
/* 560 */       this.clearcontrollersessionid = _o_.clearcontrollersessionid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.banquestendsessionid = _o_.banquestendsessionid;
/* 566 */       this.banquestsessionid = _o_.banquestsessionid;
/* 567 */       this.clearcontrollersessionid = _o_.clearcontrollersessionid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.banquestendsessionid);
/* 574 */       _os_.marshal(this.banquestsessionid);
/* 575 */       _os_.marshal(this.clearcontrollersessionid);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.banquestendsessionid = _os_.unmarshal_long();
/* 583 */       this.banquestsessionid = _os_.unmarshal_long();
/* 584 */       this.clearcontrollersessionid = _os_.unmarshal_long();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt64Size(1, this.banquestendsessionid);
/* 593 */       _size_ += CodedOutputStream.computeInt64Size(2, this.banquestsessionid);
/* 594 */       _size_ += CodedOutputStream.computeInt64Size(3, this.clearcontrollersessionid);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt64(1, this.banquestendsessionid);
/* 604 */         _output_.writeInt64(2, this.banquestsessionid);
/* 605 */         _output_.writeInt64(3, this.clearcontrollersessionid);
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
/* 632 */             this.banquestendsessionid = _input_.readInt64();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.banquestsessionid = _input_.readInt64();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.clearcontrollersessionid = _input_.readInt64();
/* 643 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 647 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 649 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 658 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 662 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 664 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BanquestSessionInfo copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BanquestSessionInfo toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.BanquestSessionInfo toBean()
/*     */     {
/* 681 */       return new BanquestSessionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BanquestSessionInfo toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.BanquestSessionInfo toBeanIf()
/*     */     {
/* 692 */       return new BanquestSessionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 698 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 718 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 722 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getBanquestendsessionid()
/*     */     {
/* 729 */       return this.banquestendsessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getBanquestsessionid()
/*     */     {
/* 736 */       return this.banquestsessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getClearcontrollersessionid()
/*     */     {
/* 743 */       return this.clearcontrollersessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBanquestendsessionid(long _v_)
/*     */     {
/* 750 */       this.banquestendsessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBanquestsessionid(long _v_)
/*     */     {
/* 757 */       this.banquestsessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setClearcontrollersessionid(long _v_)
/*     */     {
/* 764 */       this.clearcontrollersessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.banquestendsessionid != _o_.banquestendsessionid) return false;
/* 773 */       if (this.banquestsessionid != _o_.banquestsessionid) return false;
/* 774 */       if (this.clearcontrollersessionid != _o_.clearcontrollersessionid) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ = (int)(_h_ + this.banquestendsessionid);
/* 783 */       _h_ = (int)(_h_ + this.banquestsessionid);
/* 784 */       _h_ = (int)(_h_ + this.clearcontrollersessionid);
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.banquestendsessionid);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.banquestsessionid);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.clearcontrollersessionid);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BanquestSessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */