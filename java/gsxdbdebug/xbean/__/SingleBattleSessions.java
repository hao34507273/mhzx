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
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class SingleBattleSessions extends XBean implements xbean.SingleBattleSessions
/*     */ {
/*     */   private long sessionprepareid;
/*     */   private long sessionbattleplayendid;
/*     */   private long sessionbettlerealendid;
/*     */   private long sessionbettlewaitcleanid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.sessionprepareid = 0L;
/*  25 */     this.sessionbattleplayendid = 0L;
/*  26 */     this.sessionbettlerealendid = 0L;
/*  27 */     this.sessionbettlewaitcleanid = 0L;
/*     */   }
/*     */   
/*     */   SingleBattleSessions(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public SingleBattleSessions()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SingleBattleSessions(SingleBattleSessions _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SingleBattleSessions(xbean.SingleBattleSessions _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof SingleBattleSessions)) { assign((SingleBattleSessions)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SingleBattleSessions _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.sessionprepareid = _o_.sessionprepareid;
/*  58 */     this.sessionbattleplayendid = _o_.sessionbattleplayendid;
/*  59 */     this.sessionbettlerealendid = _o_.sessionbettlerealendid;
/*  60 */     this.sessionbettlewaitcleanid = _o_.sessionbettlewaitcleanid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.sessionprepareid = _o_.sessionprepareid;
/*  66 */     this.sessionbattleplayendid = _o_.sessionbattleplayendid;
/*  67 */     this.sessionbettlerealendid = _o_.sessionbettlerealendid;
/*  68 */     this.sessionbettlewaitcleanid = _o_.sessionbettlewaitcleanid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.sessionprepareid);
/*  76 */     _os_.marshal(this.sessionbattleplayendid);
/*  77 */     _os_.marshal(this.sessionbettlerealendid);
/*  78 */     _os_.marshal(this.sessionbettlewaitcleanid);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.sessionprepareid = _os_.unmarshal_long();
/*  87 */     this.sessionbattleplayendid = _os_.unmarshal_long();
/*  88 */     this.sessionbettlerealendid = _os_.unmarshal_long();
/*  89 */     this.sessionbettlewaitcleanid = _os_.unmarshal_long();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt64Size(1, this.sessionprepareid);
/*  99 */     _size_ += CodedOutputStream.computeInt64Size(2, this.sessionbattleplayendid);
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(3, this.sessionbettlerealendid);
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(4, this.sessionbettlewaitcleanid);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt64(1, this.sessionprepareid);
/* 112 */       _output_.writeInt64(2, this.sessionbattleplayendid);
/* 113 */       _output_.writeInt64(3, this.sessionbettlerealendid);
/* 114 */       _output_.writeInt64(4, this.sessionbettlewaitcleanid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 118 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 120 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       boolean done = false;
/* 130 */       while (!done)
/*     */       {
/* 132 */         int tag = _input_.readTag();
/* 133 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 137 */           done = true;
/* 138 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 142 */           this.sessionprepareid = _input_.readInt64();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.sessionbattleplayendid = _input_.readInt64();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.sessionbettlerealendid = _input_.readInt64();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.sessionbettlewaitcleanid = _input_.readInt64();
/* 158 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 162 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 164 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 173 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 177 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 179 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SingleBattleSessions copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new SingleBattleSessions(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SingleBattleSessions toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SingleBattleSessions toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new SingleBattleSessions(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SingleBattleSessions toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SingleBattleSessions toBeanIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSessionprepareid()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.sessionprepareid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSessionbattleplayendid()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.sessionbattleplayendid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSessionbettlerealendid()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.sessionbettlerealendid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSessionbettlewaitcleanid()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.sessionbettlewaitcleanid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSessionprepareid(long _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "sessionprepareid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new LogLong(this, SingleBattleSessions.this.sessionprepareid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             SingleBattleSessions.this.sessionprepareid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.sessionprepareid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSessionbattleplayendid(long _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "sessionbattleplayendid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new LogLong(this, SingleBattleSessions.this.sessionbattleplayendid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             SingleBattleSessions.this.sessionbattleplayendid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.sessionbattleplayendid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSessionbettlerealendid(long _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "sessionbettlerealendid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 305 */         new LogLong(this, SingleBattleSessions.this.sessionbettlerealendid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             SingleBattleSessions.this.sessionbettlerealendid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.sessionbettlerealendid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSessionbettlewaitcleanid(long _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "sessionbettlewaitcleanid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new LogLong(this, SingleBattleSessions.this.sessionbettlewaitcleanid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             SingleBattleSessions.this.sessionbettlewaitcleanid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.sessionbettlewaitcleanid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     SingleBattleSessions _o_ = null;
/* 343 */     if ((_o1_ instanceof SingleBattleSessions)) { _o_ = (SingleBattleSessions)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.sessionprepareid != _o_.sessionprepareid) return false;
/* 347 */     if (this.sessionbattleplayendid != _o_.sessionbattleplayendid) return false;
/* 348 */     if (this.sessionbettlerealendid != _o_.sessionbettlerealendid) return false;
/* 349 */     if (this.sessionbettlewaitcleanid != _o_.sessionbettlewaitcleanid) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ = (int)(_h_ + this.sessionprepareid);
/* 359 */     _h_ = (int)(_h_ + this.sessionbattleplayendid);
/* 360 */     _h_ = (int)(_h_ + this.sessionbettlerealendid);
/* 361 */     _h_ = (int)(_h_ + this.sessionbettlewaitcleanid);
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.sessionprepareid);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.sessionbattleplayendid);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.sessionbettlerealendid);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.sessionbettlewaitcleanid);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("sessionprepareid"));
/* 387 */     lb.add(new ListenableChanged().setVarName("sessionbattleplayendid"));
/* 388 */     lb.add(new ListenableChanged().setVarName("sessionbettlerealendid"));
/* 389 */     lb.add(new ListenableChanged().setVarName("sessionbettlewaitcleanid"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SingleBattleSessions {
/*     */     private Const() {}
/*     */     
/*     */     SingleBattleSessions nThis() {
/* 397 */       return SingleBattleSessions.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleBattleSessions copy()
/*     */     {
/* 409 */       return SingleBattleSessions.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleBattleSessions toData()
/*     */     {
/* 415 */       return SingleBattleSessions.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SingleBattleSessions toBean()
/*     */     {
/* 420 */       return SingleBattleSessions.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleBattleSessions toDataIf()
/*     */     {
/* 426 */       return SingleBattleSessions.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SingleBattleSessions toBeanIf()
/*     */     {
/* 431 */       return SingleBattleSessions.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionprepareid()
/*     */     {
/* 438 */       SingleBattleSessions.this._xdb_verify_unsafe_();
/* 439 */       return SingleBattleSessions.this.sessionprepareid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionbattleplayendid()
/*     */     {
/* 446 */       SingleBattleSessions.this._xdb_verify_unsafe_();
/* 447 */       return SingleBattleSessions.this.sessionbattleplayendid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionbettlerealendid()
/*     */     {
/* 454 */       SingleBattleSessions.this._xdb_verify_unsafe_();
/* 455 */       return SingleBattleSessions.this.sessionbettlerealendid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionbettlewaitcleanid()
/*     */     {
/* 462 */       SingleBattleSessions.this._xdb_verify_unsafe_();
/* 463 */       return SingleBattleSessions.this.sessionbettlewaitcleanid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionprepareid(long _v_)
/*     */     {
/* 470 */       SingleBattleSessions.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionbattleplayendid(long _v_)
/*     */     {
/* 478 */       SingleBattleSessions.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionbettlerealendid(long _v_)
/*     */     {
/* 486 */       SingleBattleSessions.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionbettlewaitcleanid(long _v_)
/*     */     {
/* 494 */       SingleBattleSessions.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       SingleBattleSessions.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       SingleBattleSessions.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return SingleBattleSessions.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return SingleBattleSessions.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       SingleBattleSessions.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return SingleBattleSessions.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return SingleBattleSessions.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       SingleBattleSessions.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return SingleBattleSessions.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return SingleBattleSessions.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return SingleBattleSessions.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return SingleBattleSessions.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return SingleBattleSessions.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return SingleBattleSessions.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return SingleBattleSessions.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SingleBattleSessions
/*     */   {
/*     */     private long sessionprepareid;
/*     */     
/*     */     private long sessionbattleplayendid;
/*     */     
/*     */     private long sessionbettlerealendid;
/*     */     
/*     */     private long sessionbettlewaitcleanid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 607 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.SingleBattleSessions _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof SingleBattleSessions)) { assign((SingleBattleSessions)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof SingleBattleSessions.Const)) assign(((SingleBattleSessions.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SingleBattleSessions _o_) {
/* 624 */       this.sessionprepareid = _o_.sessionprepareid;
/* 625 */       this.sessionbattleplayendid = _o_.sessionbattleplayendid;
/* 626 */       this.sessionbettlerealendid = _o_.sessionbettlerealendid;
/* 627 */       this.sessionbettlewaitcleanid = _o_.sessionbettlewaitcleanid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.sessionprepareid = _o_.sessionprepareid;
/* 633 */       this.sessionbattleplayendid = _o_.sessionbattleplayendid;
/* 634 */       this.sessionbettlerealendid = _o_.sessionbettlerealendid;
/* 635 */       this.sessionbettlewaitcleanid = _o_.sessionbettlewaitcleanid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.sessionprepareid);
/* 642 */       _os_.marshal(this.sessionbattleplayendid);
/* 643 */       _os_.marshal(this.sessionbettlerealendid);
/* 644 */       _os_.marshal(this.sessionbettlewaitcleanid);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.sessionprepareid = _os_.unmarshal_long();
/* 652 */       this.sessionbattleplayendid = _os_.unmarshal_long();
/* 653 */       this.sessionbettlerealendid = _os_.unmarshal_long();
/* 654 */       this.sessionbettlewaitcleanid = _os_.unmarshal_long();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt64Size(1, this.sessionprepareid);
/* 663 */       _size_ += CodedOutputStream.computeInt64Size(2, this.sessionbattleplayendid);
/* 664 */       _size_ += CodedOutputStream.computeInt64Size(3, this.sessionbettlerealendid);
/* 665 */       _size_ += CodedOutputStream.computeInt64Size(4, this.sessionbettlewaitcleanid);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt64(1, this.sessionprepareid);
/* 675 */         _output_.writeInt64(2, this.sessionbattleplayendid);
/* 676 */         _output_.writeInt64(3, this.sessionbettlerealendid);
/* 677 */         _output_.writeInt64(4, this.sessionbettlewaitcleanid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 681 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 683 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 691 */         boolean done = false;
/* 692 */         while (!done)
/*     */         {
/* 694 */           int tag = _input_.readTag();
/* 695 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 699 */             done = true;
/* 700 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 704 */             this.sessionprepareid = _input_.readInt64();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.sessionbattleplayendid = _input_.readInt64();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.sessionbettlerealendid = _input_.readInt64();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.sessionbettlewaitcleanid = _input_.readInt64();
/* 720 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 724 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 726 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 735 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 739 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 741 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleBattleSessions copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleBattleSessions toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SingleBattleSessions toBean()
/*     */     {
/* 758 */       return new SingleBattleSessions(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleBattleSessions toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SingleBattleSessions toBeanIf()
/*     */     {
/* 769 */       return new SingleBattleSessions(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 775 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 779 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 795 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 799 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionprepareid()
/*     */     {
/* 806 */       return this.sessionprepareid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionbattleplayendid()
/*     */     {
/* 813 */       return this.sessionbattleplayendid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionbettlerealendid()
/*     */     {
/* 820 */       return this.sessionbettlerealendid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionbettlewaitcleanid()
/*     */     {
/* 827 */       return this.sessionbettlewaitcleanid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionprepareid(long _v_)
/*     */     {
/* 834 */       this.sessionprepareid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionbattleplayendid(long _v_)
/*     */     {
/* 841 */       this.sessionbattleplayendid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionbettlerealendid(long _v_)
/*     */     {
/* 848 */       this.sessionbettlerealendid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionbettlewaitcleanid(long _v_)
/*     */     {
/* 855 */       this.sessionbettlewaitcleanid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.sessionprepareid != _o_.sessionprepareid) return false;
/* 864 */       if (this.sessionbattleplayendid != _o_.sessionbattleplayendid) return false;
/* 865 */       if (this.sessionbettlerealendid != _o_.sessionbettlerealendid) return false;
/* 866 */       if (this.sessionbettlewaitcleanid != _o_.sessionbettlewaitcleanid) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ = (int)(_h_ + this.sessionprepareid);
/* 875 */       _h_ = (int)(_h_ + this.sessionbattleplayendid);
/* 876 */       _h_ = (int)(_h_ + this.sessionbettlerealendid);
/* 877 */       _h_ = (int)(_h_ + this.sessionbettlewaitcleanid);
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.sessionprepareid);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.sessionbattleplayendid);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.sessionbettlerealendid);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.sessionbettlewaitcleanid);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SingleBattleSessions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */