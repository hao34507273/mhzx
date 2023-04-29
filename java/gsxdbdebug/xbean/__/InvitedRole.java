/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogObject;
/*     */ 
/*     */ public final class InvitedRole extends XBean implements xbean.InvitedRole
/*     */ {
/*     */   private boolean notified;
/*     */   private boolean sendgift;
/*     */   private boolean sendgiftnotified;
/*     */   private int giftcfgid;
/*     */   private long sendgifttimemil;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.notified = false;
/*  27 */     this.sendgift = false;
/*  28 */     this.sendgiftnotified = false;
/*  29 */     this.giftcfgid = 0;
/*  30 */     this.sendgifttimemil = 0L;
/*     */   }
/*     */   
/*     */   InvitedRole(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*  36 */     this.notified = false;
/*  37 */     this.sendgift = false;
/*  38 */     this.sendgiftnotified = false;
/*  39 */     this.giftcfgid = 0;
/*  40 */     this.sendgifttimemil = 0L;
/*     */   }
/*     */   
/*     */   public InvitedRole()
/*     */   {
/*  45 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public InvitedRole(InvitedRole _o_)
/*     */   {
/*  50 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   InvitedRole(xbean.InvitedRole _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  55 */     super(_xp_, _vn_);
/*  56 */     if ((_o1_ instanceof InvitedRole)) { assign((InvitedRole)_o1_);
/*  57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  59 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(InvitedRole _o_) {
/*  64 */     _o_._xdb_verify_unsafe_();
/*  65 */     this.notified = _o_.notified;
/*  66 */     this.sendgift = _o_.sendgift;
/*  67 */     this.sendgiftnotified = _o_.sendgiftnotified;
/*  68 */     this.giftcfgid = _o_.giftcfgid;
/*  69 */     this.sendgifttimemil = _o_.sendgifttimemil;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  74 */     this.notified = _o_.notified;
/*  75 */     this.sendgift = _o_.sendgift;
/*  76 */     this.sendgiftnotified = _o_.sendgiftnotified;
/*  77 */     this.giftcfgid = _o_.giftcfgid;
/*  78 */     this.sendgifttimemil = _o_.sendgifttimemil;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     _os_.marshal(this.notified);
/*  86 */     _os_.marshal(this.sendgift);
/*  87 */     _os_.marshal(this.sendgiftnotified);
/*  88 */     _os_.marshal(this.giftcfgid);
/*  89 */     _os_.marshal(this.sendgifttimemil);
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     this.notified = _os_.unmarshal_boolean();
/*  98 */     this.sendgift = _os_.unmarshal_boolean();
/*  99 */     this.sendgiftnotified = _os_.unmarshal_boolean();
/* 100 */     this.giftcfgid = _os_.unmarshal_int();
/* 101 */     this.sendgifttimemil = _os_.unmarshal_long();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/* 109 */     int _size_ = 0;
/* 110 */     _size_ += CodedOutputStream.computeBoolSize(1, this.notified);
/* 111 */     _size_ += CodedOutputStream.computeBoolSize(2, this.sendgift);
/* 112 */     _size_ += CodedOutputStream.computeBoolSize(3, this.sendgiftnotified);
/* 113 */     _size_ += CodedOutputStream.computeInt32Size(4, this.giftcfgid);
/* 114 */     _size_ += CodedOutputStream.computeInt64Size(5, this.sendgifttimemil);
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       _output_.writeBool(1, this.notified);
/* 125 */       _output_.writeBool(2, this.sendgift);
/* 126 */       _output_.writeBool(3, this.sendgiftnotified);
/* 127 */       _output_.writeInt32(4, this.giftcfgid);
/* 128 */       _output_.writeInt64(5, this.sendgifttimemil);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 132 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 134 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 143 */       boolean done = false;
/* 144 */       while (!done)
/*     */       {
/* 146 */         int tag = _input_.readTag();
/* 147 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 151 */           done = true;
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 156 */           this.notified = _input_.readBool();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 161 */           this.sendgift = _input_.readBool();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 166 */           this.sendgiftnotified = _input_.readBool();
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 171 */           this.giftcfgid = _input_.readInt32();
/* 172 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 176 */           this.sendgifttimemil = _input_.readInt64();
/* 177 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 181 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 183 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 192 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 196 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 198 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.InvitedRole copy()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new InvitedRole(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.InvitedRole toData()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.InvitedRole toBean()
/*     */   {
/* 217 */     _xdb_verify_unsafe_();
/* 218 */     return new InvitedRole(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.InvitedRole toDataIf()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.InvitedRole toBeanIf()
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getNotified()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return this.notified;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getSendgift()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this.sendgift;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getSendgiftnotified()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.sendgiftnotified;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getGiftcfgid()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return this.giftcfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSendgifttimemil()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/* 278 */     return this.sendgifttimemil;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNotified(boolean _v_)
/*     */   {
/* 285 */     _xdb_verify_unsafe_();
/* 286 */     xdb.Logs.logIf(new LogKey(this, "notified")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 290 */         new LogObject(this, Boolean.valueOf(InvitedRole.this.notified))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 294 */             InvitedRole.this.notified = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 298 */     });
/* 299 */     this.notified = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSendgift(boolean _v_)
/*     */   {
/* 306 */     _xdb_verify_unsafe_();
/* 307 */     xdb.Logs.logIf(new LogKey(this, "sendgift")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 311 */         new LogObject(this, Boolean.valueOf(InvitedRole.this.sendgift))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 315 */             InvitedRole.this.sendgift = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 319 */     });
/* 320 */     this.sendgift = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSendgiftnotified(boolean _v_)
/*     */   {
/* 327 */     _xdb_verify_unsafe_();
/* 328 */     xdb.Logs.logIf(new LogKey(this, "sendgiftnotified")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 332 */         new LogObject(this, Boolean.valueOf(InvitedRole.this.sendgiftnotified))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 336 */             InvitedRole.this.sendgiftnotified = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 340 */     });
/* 341 */     this.sendgiftnotified = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGiftcfgid(int _v_)
/*     */   {
/* 348 */     _xdb_verify_unsafe_();
/* 349 */     xdb.Logs.logIf(new LogKey(this, "giftcfgid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 353 */         new xdb.logs.LogInt(this, InvitedRole.this.giftcfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 357 */             InvitedRole.this.giftcfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 361 */     });
/* 362 */     this.giftcfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSendgifttimemil(long _v_)
/*     */   {
/* 369 */     _xdb_verify_unsafe_();
/* 370 */     xdb.Logs.logIf(new LogKey(this, "sendgifttimemil")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 374 */         new xdb.logs.LogLong(this, InvitedRole.this.sendgifttimemil)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 378 */             InvitedRole.this.sendgifttimemil = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 382 */     });
/* 383 */     this.sendgifttimemil = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     InvitedRole _o_ = null;
/* 391 */     if ((_o1_ instanceof InvitedRole)) { _o_ = (InvitedRole)_o1_;
/* 392 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 393 */       return false;
/* 394 */     if (this.notified != _o_.notified) return false;
/* 395 */     if (this.sendgift != _o_.sendgift) return false;
/* 396 */     if (this.sendgiftnotified != _o_.sendgiftnotified) return false;
/* 397 */     if (this.giftcfgid != _o_.giftcfgid) return false;
/* 398 */     if (this.sendgifttimemil != _o_.sendgifttimemil) return false;
/* 399 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 405 */     _xdb_verify_unsafe_();
/* 406 */     int _h_ = 0;
/* 407 */     _h_ += (this.notified ? 1231 : 1237);
/* 408 */     _h_ += (this.sendgift ? 1231 : 1237);
/* 409 */     _h_ += (this.sendgiftnotified ? 1231 : 1237);
/* 410 */     _h_ += this.giftcfgid;
/* 411 */     _h_ = (int)(_h_ + this.sendgifttimemil);
/* 412 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 418 */     _xdb_verify_unsafe_();
/* 419 */     StringBuilder _sb_ = new StringBuilder();
/* 420 */     _sb_.append("(");
/* 421 */     _sb_.append(this.notified);
/* 422 */     _sb_.append(",");
/* 423 */     _sb_.append(this.sendgift);
/* 424 */     _sb_.append(",");
/* 425 */     _sb_.append(this.sendgiftnotified);
/* 426 */     _sb_.append(",");
/* 427 */     _sb_.append(this.giftcfgid);
/* 428 */     _sb_.append(",");
/* 429 */     _sb_.append(this.sendgifttimemil);
/* 430 */     _sb_.append(")");
/* 431 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 437 */     ListenableBean lb = new ListenableBean();
/* 438 */     lb.add(new ListenableChanged().setVarName("notified"));
/* 439 */     lb.add(new ListenableChanged().setVarName("sendgift"));
/* 440 */     lb.add(new ListenableChanged().setVarName("sendgiftnotified"));
/* 441 */     lb.add(new ListenableChanged().setVarName("giftcfgid"));
/* 442 */     lb.add(new ListenableChanged().setVarName("sendgifttimemil"));
/* 443 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.InvitedRole {
/*     */     private Const() {}
/*     */     
/*     */     InvitedRole nThis() {
/* 450 */       return InvitedRole.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 456 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InvitedRole copy()
/*     */     {
/* 462 */       return InvitedRole.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InvitedRole toData()
/*     */     {
/* 468 */       return InvitedRole.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.InvitedRole toBean()
/*     */     {
/* 473 */       return InvitedRole.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InvitedRole toDataIf()
/*     */     {
/* 479 */       return InvitedRole.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.InvitedRole toBeanIf()
/*     */     {
/* 484 */       return InvitedRole.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getNotified()
/*     */     {
/* 491 */       InvitedRole.this._xdb_verify_unsafe_();
/* 492 */       return InvitedRole.this.notified;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getSendgift()
/*     */     {
/* 499 */       InvitedRole.this._xdb_verify_unsafe_();
/* 500 */       return InvitedRole.this.sendgift;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getSendgiftnotified()
/*     */     {
/* 507 */       InvitedRole.this._xdb_verify_unsafe_();
/* 508 */       return InvitedRole.this.sendgiftnotified;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGiftcfgid()
/*     */     {
/* 515 */       InvitedRole.this._xdb_verify_unsafe_();
/* 516 */       return InvitedRole.this.giftcfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSendgifttimemil()
/*     */     {
/* 523 */       InvitedRole.this._xdb_verify_unsafe_();
/* 524 */       return InvitedRole.this.sendgifttimemil;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNotified(boolean _v_)
/*     */     {
/* 531 */       InvitedRole.this._xdb_verify_unsafe_();
/* 532 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSendgift(boolean _v_)
/*     */     {
/* 539 */       InvitedRole.this._xdb_verify_unsafe_();
/* 540 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSendgiftnotified(boolean _v_)
/*     */     {
/* 547 */       InvitedRole.this._xdb_verify_unsafe_();
/* 548 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGiftcfgid(int _v_)
/*     */     {
/* 555 */       InvitedRole.this._xdb_verify_unsafe_();
/* 556 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSendgifttimemil(long _v_)
/*     */     {
/* 563 */       InvitedRole.this._xdb_verify_unsafe_();
/* 564 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 570 */       InvitedRole.this._xdb_verify_unsafe_();
/* 571 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 577 */       InvitedRole.this._xdb_verify_unsafe_();
/* 578 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 584 */       return InvitedRole.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 590 */       return InvitedRole.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 596 */       InvitedRole.this._xdb_verify_unsafe_();
/* 597 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 603 */       return InvitedRole.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 609 */       return InvitedRole.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 615 */       InvitedRole.this._xdb_verify_unsafe_();
/* 616 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 622 */       return InvitedRole.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 628 */       return InvitedRole.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 634 */       return InvitedRole.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 640 */       return InvitedRole.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 646 */       return InvitedRole.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 652 */       return InvitedRole.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 658 */       return InvitedRole.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.InvitedRole
/*     */   {
/*     */     private boolean notified;
/*     */     
/*     */     private boolean sendgift;
/*     */     
/*     */     private boolean sendgiftnotified;
/*     */     
/*     */     private int giftcfgid;
/*     */     
/*     */     private long sendgifttimemil;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 678 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 683 */       this.notified = false;
/* 684 */       this.sendgift = false;
/* 685 */       this.sendgiftnotified = false;
/* 686 */       this.giftcfgid = 0;
/* 687 */       this.sendgifttimemil = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.InvitedRole _o1_)
/*     */     {
/* 692 */       if ((_o1_ instanceof InvitedRole)) { assign((InvitedRole)_o1_);
/* 693 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 694 */       } else if ((_o1_ instanceof InvitedRole.Const)) assign(((InvitedRole.Const)_o1_).nThis()); else {
/* 695 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(InvitedRole _o_) {
/* 700 */       this.notified = _o_.notified;
/* 701 */       this.sendgift = _o_.sendgift;
/* 702 */       this.sendgiftnotified = _o_.sendgiftnotified;
/* 703 */       this.giftcfgid = _o_.giftcfgid;
/* 704 */       this.sendgifttimemil = _o_.sendgifttimemil;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 709 */       this.notified = _o_.notified;
/* 710 */       this.sendgift = _o_.sendgift;
/* 711 */       this.sendgiftnotified = _o_.sendgiftnotified;
/* 712 */       this.giftcfgid = _o_.giftcfgid;
/* 713 */       this.sendgifttimemil = _o_.sendgifttimemil;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 719 */       _os_.marshal(this.notified);
/* 720 */       _os_.marshal(this.sendgift);
/* 721 */       _os_.marshal(this.sendgiftnotified);
/* 722 */       _os_.marshal(this.giftcfgid);
/* 723 */       _os_.marshal(this.sendgifttimemil);
/* 724 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 730 */       this.notified = _os_.unmarshal_boolean();
/* 731 */       this.sendgift = _os_.unmarshal_boolean();
/* 732 */       this.sendgiftnotified = _os_.unmarshal_boolean();
/* 733 */       this.giftcfgid = _os_.unmarshal_int();
/* 734 */       this.sendgifttimemil = _os_.unmarshal_long();
/* 735 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 741 */       int _size_ = 0;
/* 742 */       _size_ += CodedOutputStream.computeBoolSize(1, this.notified);
/* 743 */       _size_ += CodedOutputStream.computeBoolSize(2, this.sendgift);
/* 744 */       _size_ += CodedOutputStream.computeBoolSize(3, this.sendgiftnotified);
/* 745 */       _size_ += CodedOutputStream.computeInt32Size(4, this.giftcfgid);
/* 746 */       _size_ += CodedOutputStream.computeInt64Size(5, this.sendgifttimemil);
/* 747 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 755 */         _output_.writeBool(1, this.notified);
/* 756 */         _output_.writeBool(2, this.sendgift);
/* 757 */         _output_.writeBool(3, this.sendgiftnotified);
/* 758 */         _output_.writeInt32(4, this.giftcfgid);
/* 759 */         _output_.writeInt64(5, this.sendgifttimemil);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 763 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 765 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 773 */         boolean done = false;
/* 774 */         while (!done)
/*     */         {
/* 776 */           int tag = _input_.readTag();
/* 777 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 781 */             done = true;
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 786 */             this.notified = _input_.readBool();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 791 */             this.sendgift = _input_.readBool();
/* 792 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 796 */             this.sendgiftnotified = _input_.readBool();
/* 797 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 801 */             this.giftcfgid = _input_.readInt32();
/* 802 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 806 */             this.sendgifttimemil = _input_.readInt64();
/* 807 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 811 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 813 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 822 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 826 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 828 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InvitedRole copy()
/*     */     {
/* 834 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InvitedRole toData()
/*     */     {
/* 840 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.InvitedRole toBean()
/*     */     {
/* 845 */       return new InvitedRole(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.InvitedRole toDataIf()
/*     */     {
/* 851 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.InvitedRole toBeanIf()
/*     */     {
/* 856 */       return new InvitedRole(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 862 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 866 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 870 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 874 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 878 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 882 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 886 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getNotified()
/*     */     {
/* 893 */       return this.notified;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getSendgift()
/*     */     {
/* 900 */       return this.sendgift;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getSendgiftnotified()
/*     */     {
/* 907 */       return this.sendgiftnotified;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGiftcfgid()
/*     */     {
/* 914 */       return this.giftcfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSendgifttimemil()
/*     */     {
/* 921 */       return this.sendgifttimemil;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNotified(boolean _v_)
/*     */     {
/* 928 */       this.notified = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSendgift(boolean _v_)
/*     */     {
/* 935 */       this.sendgift = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSendgiftnotified(boolean _v_)
/*     */     {
/* 942 */       this.sendgiftnotified = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGiftcfgid(int _v_)
/*     */     {
/* 949 */       this.giftcfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSendgifttimemil(long _v_)
/*     */     {
/* 956 */       this.sendgifttimemil = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 962 */       if (!(_o1_ instanceof Data)) return false;
/* 963 */       Data _o_ = (Data)_o1_;
/* 964 */       if (this.notified != _o_.notified) return false;
/* 965 */       if (this.sendgift != _o_.sendgift) return false;
/* 966 */       if (this.sendgiftnotified != _o_.sendgiftnotified) return false;
/* 967 */       if (this.giftcfgid != _o_.giftcfgid) return false;
/* 968 */       if (this.sendgifttimemil != _o_.sendgifttimemil) return false;
/* 969 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 975 */       int _h_ = 0;
/* 976 */       _h_ += (this.notified ? 1231 : 1237);
/* 977 */       _h_ += (this.sendgift ? 1231 : 1237);
/* 978 */       _h_ += (this.sendgiftnotified ? 1231 : 1237);
/* 979 */       _h_ += this.giftcfgid;
/* 980 */       _h_ = (int)(_h_ + this.sendgifttimemil);
/* 981 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 987 */       StringBuilder _sb_ = new StringBuilder();
/* 988 */       _sb_.append("(");
/* 989 */       _sb_.append(this.notified);
/* 990 */       _sb_.append(",");
/* 991 */       _sb_.append(this.sendgift);
/* 992 */       _sb_.append(",");
/* 993 */       _sb_.append(this.sendgiftnotified);
/* 994 */       _sb_.append(",");
/* 995 */       _sb_.append(this.giftcfgid);
/* 996 */       _sb_.append(",");
/* 997 */       _sb_.append(this.sendgifttimemil);
/* 998 */       _sb_.append(")");
/* 999 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\InvitedRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */