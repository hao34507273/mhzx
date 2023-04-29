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
/*     */ public final class EmbryoStageInfo extends XBean implements xbean.EmbryoStageInfo
/*     */ {
/*     */   private int embryo_cfgid;
/*     */   private int hatch_days;
/*     */   private long last_hatch_time;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.embryo_cfgid = 0;
/*  23 */     this.hatch_days = 0;
/*  24 */     this.last_hatch_time = 0L;
/*     */   }
/*     */   
/*     */   EmbryoStageInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public EmbryoStageInfo()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public EmbryoStageInfo(EmbryoStageInfo _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   EmbryoStageInfo(xbean.EmbryoStageInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof EmbryoStageInfo)) { assign((EmbryoStageInfo)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(EmbryoStageInfo _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.embryo_cfgid = _o_.embryo_cfgid;
/*  55 */     this.hatch_days = _o_.hatch_days;
/*  56 */     this.last_hatch_time = _o_.last_hatch_time;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.embryo_cfgid = _o_.embryo_cfgid;
/*  62 */     this.hatch_days = _o_.hatch_days;
/*  63 */     this.last_hatch_time = _o_.last_hatch_time;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.embryo_cfgid);
/*  71 */     _os_.marshal(this.hatch_days);
/*  72 */     _os_.marshal(this.last_hatch_time);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.embryo_cfgid = _os_.unmarshal_int();
/*  81 */     this.hatch_days = _os_.unmarshal_int();
/*  82 */     this.last_hatch_time = _os_.unmarshal_long();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt32Size(1, this.embryo_cfgid);
/*  92 */     _size_ += CodedOutputStream.computeInt32Size(2, this.hatch_days);
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(3, this.last_hatch_time);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt32(1, this.embryo_cfgid);
/* 104 */       _output_.writeInt32(2, this.hatch_days);
/* 105 */       _output_.writeInt64(3, this.last_hatch_time);
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
/* 133 */           this.embryo_cfgid = _input_.readInt32();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.hatch_days = _input_.readInt32();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.last_hatch_time = _input_.readInt64();
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
/*     */   public xbean.EmbryoStageInfo copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new EmbryoStageInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.EmbryoStageInfo toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.EmbryoStageInfo toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new EmbryoStageInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.EmbryoStageInfo toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.EmbryoStageInfo toBeanIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getEmbryo_cfgid()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.embryo_cfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getHatch_days()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.hatch_days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLast_hatch_time()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.last_hatch_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEmbryo_cfgid(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "embryo_cfgid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogInt(this, EmbryoStageInfo.this.embryo_cfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             EmbryoStageInfo.this.embryo_cfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.embryo_cfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHatch_days(int _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "hatch_days")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogInt(this, EmbryoStageInfo.this.hatch_days)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             EmbryoStageInfo.this.hatch_days = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.hatch_days = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLast_hatch_time(long _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "last_hatch_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogLong(this, EmbryoStageInfo.this.last_hatch_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             EmbryoStageInfo.this.last_hatch_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.last_hatch_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     EmbryoStageInfo _o_ = null;
/* 300 */     if ((_o1_ instanceof EmbryoStageInfo)) { _o_ = (EmbryoStageInfo)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.embryo_cfgid != _o_.embryo_cfgid) return false;
/* 304 */     if (this.hatch_days != _o_.hatch_days) return false;
/* 305 */     if (this.last_hatch_time != _o_.last_hatch_time) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ += this.embryo_cfgid;
/* 315 */     _h_ += this.hatch_days;
/* 316 */     _h_ = (int)(_h_ + this.last_hatch_time);
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.embryo_cfgid);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.hatch_days);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.last_hatch_time);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("embryo_cfgid"));
/* 340 */     lb.add(new ListenableChanged().setVarName("hatch_days"));
/* 341 */     lb.add(new ListenableChanged().setVarName("last_hatch_time"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.EmbryoStageInfo {
/*     */     private Const() {}
/*     */     
/*     */     EmbryoStageInfo nThis() {
/* 349 */       return EmbryoStageInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.EmbryoStageInfo copy()
/*     */     {
/* 361 */       return EmbryoStageInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.EmbryoStageInfo toData()
/*     */     {
/* 367 */       return EmbryoStageInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.EmbryoStageInfo toBean()
/*     */     {
/* 372 */       return EmbryoStageInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.EmbryoStageInfo toDataIf()
/*     */     {
/* 378 */       return EmbryoStageInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.EmbryoStageInfo toBeanIf()
/*     */     {
/* 383 */       return EmbryoStageInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getEmbryo_cfgid()
/*     */     {
/* 390 */       EmbryoStageInfo.this._xdb_verify_unsafe_();
/* 391 */       return EmbryoStageInfo.this.embryo_cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHatch_days()
/*     */     {
/* 398 */       EmbryoStageInfo.this._xdb_verify_unsafe_();
/* 399 */       return EmbryoStageInfo.this.hatch_days;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLast_hatch_time()
/*     */     {
/* 406 */       EmbryoStageInfo.this._xdb_verify_unsafe_();
/* 407 */       return EmbryoStageInfo.this.last_hatch_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEmbryo_cfgid(int _v_)
/*     */     {
/* 414 */       EmbryoStageInfo.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHatch_days(int _v_)
/*     */     {
/* 422 */       EmbryoStageInfo.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLast_hatch_time(long _v_)
/*     */     {
/* 430 */       EmbryoStageInfo.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       EmbryoStageInfo.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       EmbryoStageInfo.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return EmbryoStageInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return EmbryoStageInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       EmbryoStageInfo.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return EmbryoStageInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return EmbryoStageInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       EmbryoStageInfo.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return EmbryoStageInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return EmbryoStageInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return EmbryoStageInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return EmbryoStageInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return EmbryoStageInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return EmbryoStageInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return EmbryoStageInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.EmbryoStageInfo
/*     */   {
/*     */     private int embryo_cfgid;
/*     */     
/*     */     private int hatch_days;
/*     */     
/*     */     private long last_hatch_time;
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
/*     */     Data(xbean.EmbryoStageInfo _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof EmbryoStageInfo)) { assign((EmbryoStageInfo)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof EmbryoStageInfo.Const)) assign(((EmbryoStageInfo.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(EmbryoStageInfo _o_) {
/* 558 */       this.embryo_cfgid = _o_.embryo_cfgid;
/* 559 */       this.hatch_days = _o_.hatch_days;
/* 560 */       this.last_hatch_time = _o_.last_hatch_time;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.embryo_cfgid = _o_.embryo_cfgid;
/* 566 */       this.hatch_days = _o_.hatch_days;
/* 567 */       this.last_hatch_time = _o_.last_hatch_time;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.embryo_cfgid);
/* 574 */       _os_.marshal(this.hatch_days);
/* 575 */       _os_.marshal(this.last_hatch_time);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.embryo_cfgid = _os_.unmarshal_int();
/* 583 */       this.hatch_days = _os_.unmarshal_int();
/* 584 */       this.last_hatch_time = _os_.unmarshal_long();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt32Size(1, this.embryo_cfgid);
/* 593 */       _size_ += CodedOutputStream.computeInt32Size(2, this.hatch_days);
/* 594 */       _size_ += CodedOutputStream.computeInt64Size(3, this.last_hatch_time);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt32(1, this.embryo_cfgid);
/* 604 */         _output_.writeInt32(2, this.hatch_days);
/* 605 */         _output_.writeInt64(3, this.last_hatch_time);
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
/* 632 */             this.embryo_cfgid = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.hatch_days = _input_.readInt32();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.last_hatch_time = _input_.readInt64();
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
/*     */     public xbean.EmbryoStageInfo copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.EmbryoStageInfo toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.EmbryoStageInfo toBean()
/*     */     {
/* 681 */       return new EmbryoStageInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.EmbryoStageInfo toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.EmbryoStageInfo toBeanIf()
/*     */     {
/* 692 */       return new EmbryoStageInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 698 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
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
/*     */     public Bean toConst() {
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
/*     */     public int getEmbryo_cfgid()
/*     */     {
/* 729 */       return this.embryo_cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHatch_days()
/*     */     {
/* 736 */       return this.hatch_days;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLast_hatch_time()
/*     */     {
/* 743 */       return this.last_hatch_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEmbryo_cfgid(int _v_)
/*     */     {
/* 750 */       this.embryo_cfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHatch_days(int _v_)
/*     */     {
/* 757 */       this.hatch_days = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLast_hatch_time(long _v_)
/*     */     {
/* 764 */       this.last_hatch_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.embryo_cfgid != _o_.embryo_cfgid) return false;
/* 773 */       if (this.hatch_days != _o_.hatch_days) return false;
/* 774 */       if (this.last_hatch_time != _o_.last_hatch_time) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ += this.embryo_cfgid;
/* 783 */       _h_ += this.hatch_days;
/* 784 */       _h_ = (int)(_h_ + this.last_hatch_time);
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.embryo_cfgid);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.hatch_days);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.last_hatch_time);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\EmbryoStageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */