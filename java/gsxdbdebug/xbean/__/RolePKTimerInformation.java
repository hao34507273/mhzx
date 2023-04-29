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
/*     */ public final class RolePKTimerInformation extends XBean implements xbean.RolePKTimerInformation
/*     */ {
/*     */   private long pk_mode_session_id;
/*     */   private long protection_session_id;
/*     */   private long force_protection_session_id;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.pk_mode_session_id = 0L;
/*  23 */     this.protection_session_id = 0L;
/*  24 */     this.force_protection_session_id = 0L;
/*     */   }
/*     */   
/*     */   RolePKTimerInformation(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public RolePKTimerInformation()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RolePKTimerInformation(RolePKTimerInformation _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RolePKTimerInformation(xbean.RolePKTimerInformation _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof RolePKTimerInformation)) { assign((RolePKTimerInformation)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RolePKTimerInformation _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.pk_mode_session_id = _o_.pk_mode_session_id;
/*  55 */     this.protection_session_id = _o_.protection_session_id;
/*  56 */     this.force_protection_session_id = _o_.force_protection_session_id;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.pk_mode_session_id = _o_.pk_mode_session_id;
/*  62 */     this.protection_session_id = _o_.protection_session_id;
/*  63 */     this.force_protection_session_id = _o_.force_protection_session_id;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.pk_mode_session_id);
/*  71 */     _os_.marshal(this.protection_session_id);
/*  72 */     _os_.marshal(this.force_protection_session_id);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.pk_mode_session_id = _os_.unmarshal_long();
/*  81 */     this.protection_session_id = _os_.unmarshal_long();
/*  82 */     this.force_protection_session_id = _os_.unmarshal_long();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt64Size(1, this.pk_mode_session_id);
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(2, this.protection_session_id);
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(3, this.force_protection_session_id);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt64(1, this.pk_mode_session_id);
/* 104 */       _output_.writeInt64(2, this.protection_session_id);
/* 105 */       _output_.writeInt64(3, this.force_protection_session_id);
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
/* 133 */           this.pk_mode_session_id = _input_.readInt64();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.protection_session_id = _input_.readInt64();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.force_protection_session_id = _input_.readInt64();
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
/*     */   public xbean.RolePKTimerInformation copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new RolePKTimerInformation(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RolePKTimerInformation toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RolePKTimerInformation toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new RolePKTimerInformation(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RolePKTimerInformation toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RolePKTimerInformation toBeanIf()
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
/*     */   public long getPk_mode_session_id()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.pk_mode_session_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getProtection_session_id()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.protection_session_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getForce_protection_session_id()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.force_protection_session_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPk_mode_session_id(long _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "pk_mode_session_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new LogLong(this, RolePKTimerInformation.this.pk_mode_session_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             RolePKTimerInformation.this.pk_mode_session_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.pk_mode_session_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProtection_session_id(long _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "protection_session_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new LogLong(this, RolePKTimerInformation.this.protection_session_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             RolePKTimerInformation.this.protection_session_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.protection_session_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setForce_protection_session_id(long _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "force_protection_session_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new LogLong(this, RolePKTimerInformation.this.force_protection_session_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             RolePKTimerInformation.this.force_protection_session_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.force_protection_session_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     RolePKTimerInformation _o_ = null;
/* 300 */     if ((_o1_ instanceof RolePKTimerInformation)) { _o_ = (RolePKTimerInformation)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.pk_mode_session_id != _o_.pk_mode_session_id) return false;
/* 304 */     if (this.protection_session_id != _o_.protection_session_id) return false;
/* 305 */     if (this.force_protection_session_id != _o_.force_protection_session_id) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ = (int)(_h_ + this.pk_mode_session_id);
/* 315 */     _h_ = (int)(_h_ + this.protection_session_id);
/* 316 */     _h_ = (int)(_h_ + this.force_protection_session_id);
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.pk_mode_session_id);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.protection_session_id);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.force_protection_session_id);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("pk_mode_session_id"));
/* 340 */     lb.add(new ListenableChanged().setVarName("protection_session_id"));
/* 341 */     lb.add(new ListenableChanged().setVarName("force_protection_session_id"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RolePKTimerInformation {
/*     */     private Const() {}
/*     */     
/*     */     RolePKTimerInformation nThis() {
/* 349 */       return RolePKTimerInformation.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePKTimerInformation copy()
/*     */     {
/* 361 */       return RolePKTimerInformation.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePKTimerInformation toData()
/*     */     {
/* 367 */       return RolePKTimerInformation.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RolePKTimerInformation toBean()
/*     */     {
/* 372 */       return RolePKTimerInformation.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePKTimerInformation toDataIf()
/*     */     {
/* 378 */       return RolePKTimerInformation.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RolePKTimerInformation toBeanIf()
/*     */     {
/* 383 */       return RolePKTimerInformation.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPk_mode_session_id()
/*     */     {
/* 390 */       RolePKTimerInformation.this._xdb_verify_unsafe_();
/* 391 */       return RolePKTimerInformation.this.pk_mode_session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getProtection_session_id()
/*     */     {
/* 398 */       RolePKTimerInformation.this._xdb_verify_unsafe_();
/* 399 */       return RolePKTimerInformation.this.protection_session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getForce_protection_session_id()
/*     */     {
/* 406 */       RolePKTimerInformation.this._xdb_verify_unsafe_();
/* 407 */       return RolePKTimerInformation.this.force_protection_session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPk_mode_session_id(long _v_)
/*     */     {
/* 414 */       RolePKTimerInformation.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setProtection_session_id(long _v_)
/*     */     {
/* 422 */       RolePKTimerInformation.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setForce_protection_session_id(long _v_)
/*     */     {
/* 430 */       RolePKTimerInformation.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 437 */       RolePKTimerInformation.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       RolePKTimerInformation.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return RolePKTimerInformation.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return RolePKTimerInformation.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       RolePKTimerInformation.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return RolePKTimerInformation.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return RolePKTimerInformation.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       RolePKTimerInformation.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 489 */       return RolePKTimerInformation.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return RolePKTimerInformation.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return RolePKTimerInformation.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return RolePKTimerInformation.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return RolePKTimerInformation.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return RolePKTimerInformation.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return RolePKTimerInformation.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RolePKTimerInformation
/*     */   {
/*     */     private long pk_mode_session_id;
/*     */     
/*     */     private long protection_session_id;
/*     */     
/*     */     private long force_protection_session_id;
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
/*     */     Data(xbean.RolePKTimerInformation _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof RolePKTimerInformation)) { assign((RolePKTimerInformation)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof RolePKTimerInformation.Const)) assign(((RolePKTimerInformation.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RolePKTimerInformation _o_) {
/* 558 */       this.pk_mode_session_id = _o_.pk_mode_session_id;
/* 559 */       this.protection_session_id = _o_.protection_session_id;
/* 560 */       this.force_protection_session_id = _o_.force_protection_session_id;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.pk_mode_session_id = _o_.pk_mode_session_id;
/* 566 */       this.protection_session_id = _o_.protection_session_id;
/* 567 */       this.force_protection_session_id = _o_.force_protection_session_id;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.pk_mode_session_id);
/* 574 */       _os_.marshal(this.protection_session_id);
/* 575 */       _os_.marshal(this.force_protection_session_id);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.pk_mode_session_id = _os_.unmarshal_long();
/* 583 */       this.protection_session_id = _os_.unmarshal_long();
/* 584 */       this.force_protection_session_id = _os_.unmarshal_long();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt64Size(1, this.pk_mode_session_id);
/* 593 */       _size_ += CodedOutputStream.computeInt64Size(2, this.protection_session_id);
/* 594 */       _size_ += CodedOutputStream.computeInt64Size(3, this.force_protection_session_id);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt64(1, this.pk_mode_session_id);
/* 604 */         _output_.writeInt64(2, this.protection_session_id);
/* 605 */         _output_.writeInt64(3, this.force_protection_session_id);
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
/* 632 */             this.pk_mode_session_id = _input_.readInt64();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.protection_session_id = _input_.readInt64();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.force_protection_session_id = _input_.readInt64();
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
/*     */     public xbean.RolePKTimerInformation copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePKTimerInformation toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RolePKTimerInformation toBean()
/*     */     {
/* 681 */       return new RolePKTimerInformation(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePKTimerInformation toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RolePKTimerInformation toBeanIf()
/*     */     {
/* 692 */       return new RolePKTimerInformation(this, null, null);
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
/*     */     public long getPk_mode_session_id()
/*     */     {
/* 729 */       return this.pk_mode_session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getProtection_session_id()
/*     */     {
/* 736 */       return this.protection_session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getForce_protection_session_id()
/*     */     {
/* 743 */       return this.force_protection_session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPk_mode_session_id(long _v_)
/*     */     {
/* 750 */       this.pk_mode_session_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setProtection_session_id(long _v_)
/*     */     {
/* 757 */       this.protection_session_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setForce_protection_session_id(long _v_)
/*     */     {
/* 764 */       this.force_protection_session_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.pk_mode_session_id != _o_.pk_mode_session_id) return false;
/* 773 */       if (this.protection_session_id != _o_.protection_session_id) return false;
/* 774 */       if (this.force_protection_session_id != _o_.force_protection_session_id) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ = (int)(_h_ + this.pk_mode_session_id);
/* 783 */       _h_ = (int)(_h_ + this.protection_session_id);
/* 784 */       _h_ = (int)(_h_ + this.force_protection_session_id);
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.pk_mode_session_id);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.protection_session_id);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.force_protection_session_id);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RolePKTimerInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */