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
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class RoleKnockoutFightBetInfo extends XBean implements xbean.RoleKnockoutFightBetInfo
/*     */ {
/*     */   private long bet_corps_id;
/*     */   private int bet_money_num;
/*     */   private boolean has_got_mail;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.bet_corps_id = 0L;
/*  23 */     this.bet_money_num = 0;
/*  24 */     this.has_got_mail = false;
/*     */   }
/*     */   
/*     */   RoleKnockoutFightBetInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.has_got_mail = false;
/*     */   }
/*     */   
/*     */   public RoleKnockoutFightBetInfo()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleKnockoutFightBetInfo(RoleKnockoutFightBetInfo _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleKnockoutFightBetInfo(xbean.RoleKnockoutFightBetInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof RoleKnockoutFightBetInfo)) { assign((RoleKnockoutFightBetInfo)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleKnockoutFightBetInfo _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.bet_corps_id = _o_.bet_corps_id;
/*  56 */     this.bet_money_num = _o_.bet_money_num;
/*  57 */     this.has_got_mail = _o_.has_got_mail;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.bet_corps_id = _o_.bet_corps_id;
/*  63 */     this.bet_money_num = _o_.bet_money_num;
/*  64 */     this.has_got_mail = _o_.has_got_mail;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.bet_corps_id);
/*  72 */     _os_.marshal(this.bet_money_num);
/*  73 */     _os_.marshal(this.has_got_mail);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.bet_corps_id = _os_.unmarshal_long();
/*  82 */     this.bet_money_num = _os_.unmarshal_int();
/*  83 */     this.has_got_mail = _os_.unmarshal_boolean();
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     int _size_ = 0;
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(1, this.bet_corps_id);
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(2, this.bet_money_num);
/*  94 */     _size_ += CodedOutputStream.computeBoolSize(3, this.has_got_mail);
/*  95 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 104 */       _output_.writeInt64(1, this.bet_corps_id);
/* 105 */       _output_.writeInt32(2, this.bet_money_num);
/* 106 */       _output_.writeBool(3, this.has_got_mail);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 110 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 112 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 121 */       boolean done = false;
/* 122 */       while (!done)
/*     */       {
/* 124 */         int tag = _input_.readTag();
/* 125 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 129 */           done = true;
/* 130 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 134 */           this.bet_corps_id = _input_.readInt64();
/* 135 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 139 */           this.bet_money_num = _input_.readInt32();
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 144 */           this.has_got_mail = _input_.readBool();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 149 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 151 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 160 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 166 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleKnockoutFightBetInfo copy()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new RoleKnockoutFightBetInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleKnockoutFightBetInfo toData()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleKnockoutFightBetInfo toBean()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new RoleKnockoutFightBetInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleKnockoutFightBetInfo toDataIf()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleKnockoutFightBetInfo toBeanIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getBet_corps_id()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this.bet_corps_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getBet_money_num()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return this.bet_money_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getHas_got_mail()
/*     */   {
/* 229 */     _xdb_verify_unsafe_();
/* 230 */     return this.has_got_mail;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBet_corps_id(long _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "bet_corps_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new xdb.logs.LogLong(this, RoleKnockoutFightBetInfo.this.bet_corps_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             RoleKnockoutFightBetInfo.this.bet_corps_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.bet_corps_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBet_money_num(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "bet_money_num")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new xdb.logs.LogInt(this, RoleKnockoutFightBetInfo.this.bet_money_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             RoleKnockoutFightBetInfo.this.bet_money_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.bet_money_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHas_got_mail(boolean _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "has_got_mail")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new xdb.logs.LogObject(this, Boolean.valueOf(RoleKnockoutFightBetInfo.this.has_got_mail))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             RoleKnockoutFightBetInfo.this.has_got_mail = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.has_got_mail = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 299 */     _xdb_verify_unsafe_();
/* 300 */     RoleKnockoutFightBetInfo _o_ = null;
/* 301 */     if ((_o1_ instanceof RoleKnockoutFightBetInfo)) { _o_ = (RoleKnockoutFightBetInfo)_o1_;
/* 302 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 303 */       return false;
/* 304 */     if (this.bet_corps_id != _o_.bet_corps_id) return false;
/* 305 */     if (this.bet_money_num != _o_.bet_money_num) return false;
/* 306 */     if (this.has_got_mail != _o_.has_got_mail) return false;
/* 307 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     int _h_ = 0;
/* 315 */     _h_ = (int)(_h_ + this.bet_corps_id);
/* 316 */     _h_ += this.bet_money_num;
/* 317 */     _h_ += (this.has_got_mail ? 1231 : 1237);
/* 318 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     StringBuilder _sb_ = new StringBuilder();
/* 326 */     _sb_.append("(");
/* 327 */     _sb_.append(this.bet_corps_id);
/* 328 */     _sb_.append(",");
/* 329 */     _sb_.append(this.bet_money_num);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.has_got_mail);
/* 332 */     _sb_.append(")");
/* 333 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 339 */     ListenableBean lb = new ListenableBean();
/* 340 */     lb.add(new ListenableChanged().setVarName("bet_corps_id"));
/* 341 */     lb.add(new ListenableChanged().setVarName("bet_money_num"));
/* 342 */     lb.add(new ListenableChanged().setVarName("has_got_mail"));
/* 343 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleKnockoutFightBetInfo {
/*     */     private Const() {}
/*     */     
/*     */     RoleKnockoutFightBetInfo nThis() {
/* 350 */       return RoleKnockoutFightBetInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 356 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleKnockoutFightBetInfo copy()
/*     */     {
/* 362 */       return RoleKnockoutFightBetInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleKnockoutFightBetInfo toData()
/*     */     {
/* 368 */       return RoleKnockoutFightBetInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleKnockoutFightBetInfo toBean()
/*     */     {
/* 373 */       return RoleKnockoutFightBetInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleKnockoutFightBetInfo toDataIf()
/*     */     {
/* 379 */       return RoleKnockoutFightBetInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleKnockoutFightBetInfo toBeanIf()
/*     */     {
/* 384 */       return RoleKnockoutFightBetInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getBet_corps_id()
/*     */     {
/* 391 */       RoleKnockoutFightBetInfo.this._xdb_verify_unsafe_();
/* 392 */       return RoleKnockoutFightBetInfo.this.bet_corps_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getBet_money_num()
/*     */     {
/* 399 */       RoleKnockoutFightBetInfo.this._xdb_verify_unsafe_();
/* 400 */       return RoleKnockoutFightBetInfo.this.bet_money_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getHas_got_mail()
/*     */     {
/* 407 */       RoleKnockoutFightBetInfo.this._xdb_verify_unsafe_();
/* 408 */       return RoleKnockoutFightBetInfo.this.has_got_mail;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBet_corps_id(long _v_)
/*     */     {
/* 415 */       RoleKnockoutFightBetInfo.this._xdb_verify_unsafe_();
/* 416 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBet_money_num(int _v_)
/*     */     {
/* 423 */       RoleKnockoutFightBetInfo.this._xdb_verify_unsafe_();
/* 424 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHas_got_mail(boolean _v_)
/*     */     {
/* 431 */       RoleKnockoutFightBetInfo.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 438 */       RoleKnockoutFightBetInfo.this._xdb_verify_unsafe_();
/* 439 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 445 */       RoleKnockoutFightBetInfo.this._xdb_verify_unsafe_();
/* 446 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 452 */       return RoleKnockoutFightBetInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 458 */       return RoleKnockoutFightBetInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 464 */       RoleKnockoutFightBetInfo.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 471 */       return RoleKnockoutFightBetInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 477 */       return RoleKnockoutFightBetInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 483 */       RoleKnockoutFightBetInfo.this._xdb_verify_unsafe_();
/* 484 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 490 */       return RoleKnockoutFightBetInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 496 */       return RoleKnockoutFightBetInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 502 */       return RoleKnockoutFightBetInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 508 */       return RoleKnockoutFightBetInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 514 */       return RoleKnockoutFightBetInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 520 */       return RoleKnockoutFightBetInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 526 */       return RoleKnockoutFightBetInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleKnockoutFightBetInfo
/*     */   {
/*     */     private long bet_corps_id;
/*     */     
/*     */     private int bet_money_num;
/*     */     
/*     */     private boolean has_got_mail;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 542 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 547 */       this.has_got_mail = false;
/*     */     }
/*     */     
/*     */     Data(xbean.RoleKnockoutFightBetInfo _o1_)
/*     */     {
/* 552 */       if ((_o1_ instanceof RoleKnockoutFightBetInfo)) { assign((RoleKnockoutFightBetInfo)_o1_);
/* 553 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 554 */       } else if ((_o1_ instanceof RoleKnockoutFightBetInfo.Const)) assign(((RoleKnockoutFightBetInfo.Const)_o1_).nThis()); else {
/* 555 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleKnockoutFightBetInfo _o_) {
/* 560 */       this.bet_corps_id = _o_.bet_corps_id;
/* 561 */       this.bet_money_num = _o_.bet_money_num;
/* 562 */       this.has_got_mail = _o_.has_got_mail;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 567 */       this.bet_corps_id = _o_.bet_corps_id;
/* 568 */       this.bet_money_num = _o_.bet_money_num;
/* 569 */       this.has_got_mail = _o_.has_got_mail;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 575 */       _os_.marshal(this.bet_corps_id);
/* 576 */       _os_.marshal(this.bet_money_num);
/* 577 */       _os_.marshal(this.has_got_mail);
/* 578 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 584 */       this.bet_corps_id = _os_.unmarshal_long();
/* 585 */       this.bet_money_num = _os_.unmarshal_int();
/* 586 */       this.has_got_mail = _os_.unmarshal_boolean();
/* 587 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 593 */       int _size_ = 0;
/* 594 */       _size_ += CodedOutputStream.computeInt64Size(1, this.bet_corps_id);
/* 595 */       _size_ += CodedOutputStream.computeInt32Size(2, this.bet_money_num);
/* 596 */       _size_ += CodedOutputStream.computeBoolSize(3, this.has_got_mail);
/* 597 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 605 */         _output_.writeInt64(1, this.bet_corps_id);
/* 606 */         _output_.writeInt32(2, this.bet_money_num);
/* 607 */         _output_.writeBool(3, this.has_got_mail);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 611 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 613 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 621 */         boolean done = false;
/* 622 */         while (!done)
/*     */         {
/* 624 */           int tag = _input_.readTag();
/* 625 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 629 */             done = true;
/* 630 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 634 */             this.bet_corps_id = _input_.readInt64();
/* 635 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 639 */             this.bet_money_num = _input_.readInt32();
/* 640 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 644 */             this.has_got_mail = _input_.readBool();
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
/*     */     public xbean.RoleKnockoutFightBetInfo copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleKnockoutFightBetInfo toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleKnockoutFightBetInfo toBean()
/*     */     {
/* 683 */       return new RoleKnockoutFightBetInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleKnockoutFightBetInfo toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleKnockoutFightBetInfo toBeanIf()
/*     */     {
/* 694 */       return new RoleKnockoutFightBetInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
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
/*     */     public Bean toConst() {
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
/*     */     public long getBet_corps_id()
/*     */     {
/* 731 */       return this.bet_corps_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getBet_money_num()
/*     */     {
/* 738 */       return this.bet_money_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getHas_got_mail()
/*     */     {
/* 745 */       return this.has_got_mail;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBet_corps_id(long _v_)
/*     */     {
/* 752 */       this.bet_corps_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBet_money_num(int _v_)
/*     */     {
/* 759 */       this.bet_money_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHas_got_mail(boolean _v_)
/*     */     {
/* 766 */       this.has_got_mail = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 772 */       if (!(_o1_ instanceof Data)) return false;
/* 773 */       Data _o_ = (Data)_o1_;
/* 774 */       if (this.bet_corps_id != _o_.bet_corps_id) return false;
/* 775 */       if (this.bet_money_num != _o_.bet_money_num) return false;
/* 776 */       if (this.has_got_mail != _o_.has_got_mail) return false;
/* 777 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 783 */       int _h_ = 0;
/* 784 */       _h_ = (int)(_h_ + this.bet_corps_id);
/* 785 */       _h_ += this.bet_money_num;
/* 786 */       _h_ += (this.has_got_mail ? 1231 : 1237);
/* 787 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 793 */       StringBuilder _sb_ = new StringBuilder();
/* 794 */       _sb_.append("(");
/* 795 */       _sb_.append(this.bet_corps_id);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.bet_money_num);
/* 798 */       _sb_.append(",");
/* 799 */       _sb_.append(this.has_got_mail);
/* 800 */       _sb_.append(")");
/* 801 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleKnockoutFightBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */