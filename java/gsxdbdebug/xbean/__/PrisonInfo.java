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
/*     */ public final class PrisonInfo extends XBean implements xbean.PrisonInfo
/*     */ {
/*     */   private long enterjailtimestamp;
/*     */   private long sessionid;
/*     */   private int jailaction;
/*     */   private long injailonlinetime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.enterjailtimestamp = 0L;
/*  25 */     this.sessionid = 0L;
/*  26 */     this.jailaction = 0;
/*  27 */     this.injailonlinetime = 0L;
/*     */   }
/*     */   
/*     */   PrisonInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public PrisonInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PrisonInfo(PrisonInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PrisonInfo(xbean.PrisonInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof PrisonInfo)) { assign((PrisonInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PrisonInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.enterjailtimestamp = _o_.enterjailtimestamp;
/*  58 */     this.sessionid = _o_.sessionid;
/*  59 */     this.jailaction = _o_.jailaction;
/*  60 */     this.injailonlinetime = _o_.injailonlinetime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.enterjailtimestamp = _o_.enterjailtimestamp;
/*  66 */     this.sessionid = _o_.sessionid;
/*  67 */     this.jailaction = _o_.jailaction;
/*  68 */     this.injailonlinetime = _o_.injailonlinetime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.enterjailtimestamp);
/*  76 */     _os_.marshal(this.sessionid);
/*  77 */     _os_.marshal(this.jailaction);
/*  78 */     _os_.marshal(this.injailonlinetime);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.enterjailtimestamp = _os_.unmarshal_long();
/*  87 */     this.sessionid = _os_.unmarshal_long();
/*  88 */     this.jailaction = _os_.unmarshal_int();
/*  89 */     this.injailonlinetime = _os_.unmarshal_long();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt64Size(1, this.enterjailtimestamp);
/*  99 */     _size_ += CodedOutputStream.computeInt64Size(2, this.sessionid);
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(3, this.jailaction);
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(4, this.injailonlinetime);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt64(1, this.enterjailtimestamp);
/* 112 */       _output_.writeInt64(2, this.sessionid);
/* 113 */       _output_.writeInt32(3, this.jailaction);
/* 114 */       _output_.writeInt64(4, this.injailonlinetime);
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
/* 142 */           this.enterjailtimestamp = _input_.readInt64();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.sessionid = _input_.readInt64();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.jailaction = _input_.readInt32();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.injailonlinetime = _input_.readInt64();
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
/*     */   public xbean.PrisonInfo copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new PrisonInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PrisonInfo toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PrisonInfo toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new PrisonInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PrisonInfo toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PrisonInfo toBeanIf()
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
/*     */   public long getEnterjailtimestamp()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.enterjailtimestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSessionid()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getJailaction()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.jailaction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getInjailonlinetime()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.injailonlinetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEnterjailtimestamp(long _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "enterjailtimestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new LogLong(this, PrisonInfo.this.enterjailtimestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             PrisonInfo.this.enterjailtimestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.enterjailtimestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSessionid(long _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "sessionid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new LogLong(this, PrisonInfo.this.sessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             PrisonInfo.this.sessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.sessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setJailaction(int _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "jailaction")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 305 */         new xdb.logs.LogInt(this, PrisonInfo.this.jailaction)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             PrisonInfo.this.jailaction = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.jailaction = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setInjailonlinetime(long _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "injailonlinetime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new LogLong(this, PrisonInfo.this.injailonlinetime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             PrisonInfo.this.injailonlinetime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.injailonlinetime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     PrisonInfo _o_ = null;
/* 343 */     if ((_o1_ instanceof PrisonInfo)) { _o_ = (PrisonInfo)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.enterjailtimestamp != _o_.enterjailtimestamp) return false;
/* 347 */     if (this.sessionid != _o_.sessionid) return false;
/* 348 */     if (this.jailaction != _o_.jailaction) return false;
/* 349 */     if (this.injailonlinetime != _o_.injailonlinetime) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ = (int)(_h_ + this.enterjailtimestamp);
/* 359 */     _h_ = (int)(_h_ + this.sessionid);
/* 360 */     _h_ += this.jailaction;
/* 361 */     _h_ = (int)(_h_ + this.injailonlinetime);
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.enterjailtimestamp);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.sessionid);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.jailaction);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.injailonlinetime);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("enterjailtimestamp"));
/* 387 */     lb.add(new ListenableChanged().setVarName("sessionid"));
/* 388 */     lb.add(new ListenableChanged().setVarName("jailaction"));
/* 389 */     lb.add(new ListenableChanged().setVarName("injailonlinetime"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PrisonInfo {
/*     */     private Const() {}
/*     */     
/*     */     PrisonInfo nThis() {
/* 397 */       return PrisonInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PrisonInfo copy()
/*     */     {
/* 409 */       return PrisonInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PrisonInfo toData()
/*     */     {
/* 415 */       return PrisonInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PrisonInfo toBean()
/*     */     {
/* 420 */       return PrisonInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PrisonInfo toDataIf()
/*     */     {
/* 426 */       return PrisonInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PrisonInfo toBeanIf()
/*     */     {
/* 431 */       return PrisonInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getEnterjailtimestamp()
/*     */     {
/* 438 */       PrisonInfo.this._xdb_verify_unsafe_();
/* 439 */       return PrisonInfo.this.enterjailtimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 446 */       PrisonInfo.this._xdb_verify_unsafe_();
/* 447 */       return PrisonInfo.this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getJailaction()
/*     */     {
/* 454 */       PrisonInfo.this._xdb_verify_unsafe_();
/* 455 */       return PrisonInfo.this.jailaction;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getInjailonlinetime()
/*     */     {
/* 462 */       PrisonInfo.this._xdb_verify_unsafe_();
/* 463 */       return PrisonInfo.this.injailonlinetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEnterjailtimestamp(long _v_)
/*     */     {
/* 470 */       PrisonInfo.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 478 */       PrisonInfo.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setJailaction(int _v_)
/*     */     {
/* 486 */       PrisonInfo.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInjailonlinetime(long _v_)
/*     */     {
/* 494 */       PrisonInfo.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       PrisonInfo.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       PrisonInfo.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return PrisonInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return PrisonInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       PrisonInfo.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return PrisonInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return PrisonInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       PrisonInfo.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return PrisonInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return PrisonInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return PrisonInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return PrisonInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return PrisonInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return PrisonInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return PrisonInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PrisonInfo
/*     */   {
/*     */     private long enterjailtimestamp;
/*     */     
/*     */     private long sessionid;
/*     */     
/*     */     private int jailaction;
/*     */     
/*     */     private long injailonlinetime;
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
/*     */     Data(xbean.PrisonInfo _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof PrisonInfo)) { assign((PrisonInfo)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof PrisonInfo.Const)) assign(((PrisonInfo.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PrisonInfo _o_) {
/* 624 */       this.enterjailtimestamp = _o_.enterjailtimestamp;
/* 625 */       this.sessionid = _o_.sessionid;
/* 626 */       this.jailaction = _o_.jailaction;
/* 627 */       this.injailonlinetime = _o_.injailonlinetime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.enterjailtimestamp = _o_.enterjailtimestamp;
/* 633 */       this.sessionid = _o_.sessionid;
/* 634 */       this.jailaction = _o_.jailaction;
/* 635 */       this.injailonlinetime = _o_.injailonlinetime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.enterjailtimestamp);
/* 642 */       _os_.marshal(this.sessionid);
/* 643 */       _os_.marshal(this.jailaction);
/* 644 */       _os_.marshal(this.injailonlinetime);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.enterjailtimestamp = _os_.unmarshal_long();
/* 652 */       this.sessionid = _os_.unmarshal_long();
/* 653 */       this.jailaction = _os_.unmarshal_int();
/* 654 */       this.injailonlinetime = _os_.unmarshal_long();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt64Size(1, this.enterjailtimestamp);
/* 663 */       _size_ += CodedOutputStream.computeInt64Size(2, this.sessionid);
/* 664 */       _size_ += CodedOutputStream.computeInt32Size(3, this.jailaction);
/* 665 */       _size_ += CodedOutputStream.computeInt64Size(4, this.injailonlinetime);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt64(1, this.enterjailtimestamp);
/* 675 */         _output_.writeInt64(2, this.sessionid);
/* 676 */         _output_.writeInt32(3, this.jailaction);
/* 677 */         _output_.writeInt64(4, this.injailonlinetime);
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
/* 704 */             this.enterjailtimestamp = _input_.readInt64();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.sessionid = _input_.readInt64();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.jailaction = _input_.readInt32();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.injailonlinetime = _input_.readInt64();
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
/*     */     public xbean.PrisonInfo copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PrisonInfo toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PrisonInfo toBean()
/*     */     {
/* 758 */       return new PrisonInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PrisonInfo toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PrisonInfo toBeanIf()
/*     */     {
/* 769 */       return new PrisonInfo(this, null, null);
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
/*     */     public long getEnterjailtimestamp()
/*     */     {
/* 806 */       return this.enterjailtimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 813 */       return this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getJailaction()
/*     */     {
/* 820 */       return this.jailaction;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getInjailonlinetime()
/*     */     {
/* 827 */       return this.injailonlinetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEnterjailtimestamp(long _v_)
/*     */     {
/* 834 */       this.enterjailtimestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 841 */       this.sessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setJailaction(int _v_)
/*     */     {
/* 848 */       this.jailaction = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInjailonlinetime(long _v_)
/*     */     {
/* 855 */       this.injailonlinetime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.enterjailtimestamp != _o_.enterjailtimestamp) return false;
/* 864 */       if (this.sessionid != _o_.sessionid) return false;
/* 865 */       if (this.jailaction != _o_.jailaction) return false;
/* 866 */       if (this.injailonlinetime != _o_.injailonlinetime) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ = (int)(_h_ + this.enterjailtimestamp);
/* 875 */       _h_ = (int)(_h_ + this.sessionid);
/* 876 */       _h_ += this.jailaction;
/* 877 */       _h_ = (int)(_h_ + this.injailonlinetime);
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.enterjailtimestamp);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.sessionid);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.jailaction);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.injailonlinetime);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PrisonInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */