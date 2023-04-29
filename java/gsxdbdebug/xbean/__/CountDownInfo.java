/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class CountDownInfo extends XBean implements xbean.CountDownInfo
/*     */ {
/*     */   private SetX<Integer> remind_mails;
/*     */   private SetX<Integer> thank_mails;
/*     */   private boolean get_red_packet;
/*     */   private boolean can_get_red_packet;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.remind_mails.clear();
/*  25 */     this.thank_mails.clear();
/*  26 */     this.get_red_packet = false;
/*  27 */     this.can_get_red_packet = false;
/*     */   }
/*     */   
/*     */   CountDownInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.remind_mails = new SetX();
/*  34 */     this.thank_mails = new SetX();
/*  35 */     this.get_red_packet = false;
/*  36 */     this.can_get_red_packet = false;
/*     */   }
/*     */   
/*     */   public CountDownInfo()
/*     */   {
/*  41 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CountDownInfo(CountDownInfo _o_)
/*     */   {
/*  46 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CountDownInfo(xbean.CountDownInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  51 */     super(_xp_, _vn_);
/*  52 */     if ((_o1_ instanceof CountDownInfo)) { assign((CountDownInfo)_o1_);
/*  53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  55 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CountDownInfo _o_) {
/*  60 */     _o_._xdb_verify_unsafe_();
/*  61 */     this.remind_mails = new SetX();
/*  62 */     this.remind_mails.addAll(_o_.remind_mails);
/*  63 */     this.thank_mails = new SetX();
/*  64 */     this.thank_mails.addAll(_o_.thank_mails);
/*  65 */     this.get_red_packet = _o_.get_red_packet;
/*  66 */     this.can_get_red_packet = _o_.can_get_red_packet;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  71 */     this.remind_mails = new SetX();
/*  72 */     this.remind_mails.addAll(_o_.remind_mails);
/*  73 */     this.thank_mails = new SetX();
/*  74 */     this.thank_mails.addAll(_o_.thank_mails);
/*  75 */     this.get_red_packet = _o_.get_red_packet;
/*  76 */     this.can_get_red_packet = _o_.can_get_red_packet;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     _os_.compact_uint32(this.remind_mails.size());
/*  84 */     for (Integer _v_ : this.remind_mails)
/*     */     {
/*  86 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  88 */     _os_.compact_uint32(this.thank_mails.size());
/*  89 */     for (Integer _v_ : this.thank_mails)
/*     */     {
/*  91 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  93 */     _os_.marshal(this.get_red_packet);
/*  94 */     _os_.marshal(this.can_get_red_packet);
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/* 102 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 104 */       int _v_ = 0;
/* 105 */       _v_ = _os_.unmarshal_int();
/* 106 */       this.remind_mails.add(Integer.valueOf(_v_));
/*     */     }
/* 108 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 110 */       int _v_ = 0;
/* 111 */       _v_ = _os_.unmarshal_int();
/* 112 */       this.thank_mails.add(Integer.valueOf(_v_));
/*     */     }
/* 114 */     this.get_red_packet = _os_.unmarshal_boolean();
/* 115 */     this.can_get_red_packet = _os_.unmarshal_boolean();
/* 116 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 122 */     _xdb_verify_unsafe_();
/* 123 */     int _size_ = 0;
/* 124 */     for (Integer _v_ : this.remind_mails)
/*     */     {
/* 126 */       _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */     }
/* 128 */     for (Integer _v_ : this.thank_mails)
/*     */     {
/* 130 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */     }
/* 132 */     _size_ += CodedOutputStream.computeBoolSize(3, this.get_red_packet);
/* 133 */     _size_ += CodedOutputStream.computeBoolSize(4, this.can_get_red_packet);
/* 134 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 143 */       for (Integer _v_ : this.remind_mails)
/*     */       {
/* 145 */         _output_.writeInt32(1, _v_.intValue());
/*     */       }
/* 147 */       for (Integer _v_ : this.thank_mails)
/*     */       {
/* 149 */         _output_.writeInt32(2, _v_.intValue());
/*     */       }
/* 151 */       _output_.writeBool(3, this.get_red_packet);
/* 152 */       _output_.writeBool(4, this.can_get_red_packet);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 156 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 158 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 167 */       boolean done = false;
/* 168 */       while (!done)
/*     */       {
/* 170 */         int tag = _input_.readTag();
/* 171 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 175 */           done = true;
/* 176 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 180 */           int _v_ = 0;
/* 181 */           _v_ = _input_.readInt32();
/* 182 */           this.remind_mails.add(Integer.valueOf(_v_));
/* 183 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 187 */           int _v_ = 0;
/* 188 */           _v_ = _input_.readInt32();
/* 189 */           this.thank_mails.add(Integer.valueOf(_v_));
/* 190 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 194 */           this.get_red_packet = _input_.readBool();
/* 195 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 199 */           this.can_get_red_packet = _input_.readBool();
/* 200 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 204 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 206 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 215 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 219 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 221 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CountDownInfo copy()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return new CountDownInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CountDownInfo toData()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CountDownInfo toBean()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return new CountDownInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CountDownInfo toDataIf()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CountDownInfo toBeanIf()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getRemind_mails()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     return xdb.Logs.logSet(new LogKey(this, "remind_mails"), this.remind_mails);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getRemind_mailsAsData()
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/*     */     
/* 277 */     CountDownInfo _o_ = this;
/* 278 */     Set<Integer> remind_mails = new SetX();
/* 279 */     remind_mails.addAll(_o_.remind_mails);
/* 280 */     return remind_mails;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getThank_mails()
/*     */   {
/* 287 */     _xdb_verify_unsafe_();
/* 288 */     return xdb.Logs.logSet(new LogKey(this, "thank_mails"), this.thank_mails);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getThank_mailsAsData()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/*     */     
/* 296 */     CountDownInfo _o_ = this;
/* 297 */     Set<Integer> thank_mails = new SetX();
/* 298 */     thank_mails.addAll(_o_.thank_mails);
/* 299 */     return thank_mails;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getGet_red_packet()
/*     */   {
/* 306 */     _xdb_verify_unsafe_();
/* 307 */     return this.get_red_packet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getCan_get_red_packet()
/*     */   {
/* 314 */     _xdb_verify_unsafe_();
/* 315 */     return this.can_get_red_packet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGet_red_packet(boolean _v_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     xdb.Logs.logIf(new LogKey(this, "get_red_packet")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 327 */         new xdb.logs.LogObject(this, Boolean.valueOf(CountDownInfo.this.get_red_packet))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 331 */             CountDownInfo.this.get_red_packet = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 335 */     });
/* 336 */     this.get_red_packet = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCan_get_red_packet(boolean _v_)
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/* 344 */     xdb.Logs.logIf(new LogKey(this, "can_get_red_packet")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 348 */         new xdb.logs.LogObject(this, Boolean.valueOf(CountDownInfo.this.can_get_red_packet))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 352 */             CountDownInfo.this.can_get_red_packet = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 356 */     });
/* 357 */     this.can_get_red_packet = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 363 */     _xdb_verify_unsafe_();
/* 364 */     CountDownInfo _o_ = null;
/* 365 */     if ((_o1_ instanceof CountDownInfo)) { _o_ = (CountDownInfo)_o1_;
/* 366 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 367 */       return false;
/* 368 */     if (!this.remind_mails.equals(_o_.remind_mails)) return false;
/* 369 */     if (!this.thank_mails.equals(_o_.thank_mails)) return false;
/* 370 */     if (this.get_red_packet != _o_.get_red_packet) return false;
/* 371 */     if (this.can_get_red_packet != _o_.can_get_red_packet) return false;
/* 372 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 378 */     _xdb_verify_unsafe_();
/* 379 */     int _h_ = 0;
/* 380 */     _h_ += this.remind_mails.hashCode();
/* 381 */     _h_ += this.thank_mails.hashCode();
/* 382 */     _h_ += (this.get_red_packet ? 1231 : 1237);
/* 383 */     _h_ += (this.can_get_red_packet ? 1231 : 1237);
/* 384 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 390 */     _xdb_verify_unsafe_();
/* 391 */     StringBuilder _sb_ = new StringBuilder();
/* 392 */     _sb_.append("(");
/* 393 */     _sb_.append(this.remind_mails);
/* 394 */     _sb_.append(",");
/* 395 */     _sb_.append(this.thank_mails);
/* 396 */     _sb_.append(",");
/* 397 */     _sb_.append(this.get_red_packet);
/* 398 */     _sb_.append(",");
/* 399 */     _sb_.append(this.can_get_red_packet);
/* 400 */     _sb_.append(")");
/* 401 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 407 */     ListenableBean lb = new ListenableBean();
/* 408 */     lb.add(new xdb.logs.ListenableSet().setVarName("remind_mails"));
/* 409 */     lb.add(new xdb.logs.ListenableSet().setVarName("thank_mails"));
/* 410 */     lb.add(new xdb.logs.ListenableChanged().setVarName("get_red_packet"));
/* 411 */     lb.add(new xdb.logs.ListenableChanged().setVarName("can_get_red_packet"));
/* 412 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CountDownInfo {
/*     */     private Const() {}
/*     */     
/*     */     CountDownInfo nThis() {
/* 419 */       return CountDownInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 425 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CountDownInfo copy()
/*     */     {
/* 431 */       return CountDownInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CountDownInfo toData()
/*     */     {
/* 437 */       return CountDownInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CountDownInfo toBean()
/*     */     {
/* 442 */       return CountDownInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CountDownInfo toDataIf()
/*     */     {
/* 448 */       return CountDownInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CountDownInfo toBeanIf()
/*     */     {
/* 453 */       return CountDownInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getRemind_mails()
/*     */     {
/* 460 */       CountDownInfo.this._xdb_verify_unsafe_();
/* 461 */       return xdb.Consts.constSet(CountDownInfo.this.remind_mails);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getRemind_mailsAsData()
/*     */     {
/* 467 */       CountDownInfo.this._xdb_verify_unsafe_();
/*     */       
/* 469 */       CountDownInfo _o_ = CountDownInfo.this;
/* 470 */       Set<Integer> remind_mails = new SetX();
/* 471 */       remind_mails.addAll(_o_.remind_mails);
/* 472 */       return remind_mails;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getThank_mails()
/*     */     {
/* 479 */       CountDownInfo.this._xdb_verify_unsafe_();
/* 480 */       return xdb.Consts.constSet(CountDownInfo.this.thank_mails);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getThank_mailsAsData()
/*     */     {
/* 486 */       CountDownInfo.this._xdb_verify_unsafe_();
/*     */       
/* 488 */       CountDownInfo _o_ = CountDownInfo.this;
/* 489 */       Set<Integer> thank_mails = new SetX();
/* 490 */       thank_mails.addAll(_o_.thank_mails);
/* 491 */       return thank_mails;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getGet_red_packet()
/*     */     {
/* 498 */       CountDownInfo.this._xdb_verify_unsafe_();
/* 499 */       return CountDownInfo.this.get_red_packet;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getCan_get_red_packet()
/*     */     {
/* 506 */       CountDownInfo.this._xdb_verify_unsafe_();
/* 507 */       return CountDownInfo.this.can_get_red_packet;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGet_red_packet(boolean _v_)
/*     */     {
/* 514 */       CountDownInfo.this._xdb_verify_unsafe_();
/* 515 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCan_get_red_packet(boolean _v_)
/*     */     {
/* 522 */       CountDownInfo.this._xdb_verify_unsafe_();
/* 523 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 529 */       CountDownInfo.this._xdb_verify_unsafe_();
/* 530 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 536 */       CountDownInfo.this._xdb_verify_unsafe_();
/* 537 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 543 */       return CountDownInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 549 */       return CountDownInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 555 */       CountDownInfo.this._xdb_verify_unsafe_();
/* 556 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 562 */       return CountDownInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 568 */       return CountDownInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 574 */       CountDownInfo.this._xdb_verify_unsafe_();
/* 575 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 581 */       return CountDownInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 587 */       return CountDownInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 593 */       return CountDownInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 599 */       return CountDownInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 605 */       return CountDownInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 611 */       return CountDownInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 617 */       return CountDownInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CountDownInfo
/*     */   {
/*     */     private HashSet<Integer> remind_mails;
/*     */     
/*     */     private HashSet<Integer> thank_mails;
/*     */     
/*     */     private boolean get_red_packet;
/*     */     
/*     */     private boolean can_get_red_packet;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 635 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 640 */       this.remind_mails = new HashSet();
/* 641 */       this.thank_mails = new HashSet();
/* 642 */       this.get_red_packet = false;
/* 643 */       this.can_get_red_packet = false;
/*     */     }
/*     */     
/*     */     Data(xbean.CountDownInfo _o1_)
/*     */     {
/* 648 */       if ((_o1_ instanceof CountDownInfo)) { assign((CountDownInfo)_o1_);
/* 649 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 650 */       } else if ((_o1_ instanceof CountDownInfo.Const)) assign(((CountDownInfo.Const)_o1_).nThis()); else {
/* 651 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CountDownInfo _o_) {
/* 656 */       this.remind_mails = new HashSet();
/* 657 */       this.remind_mails.addAll(_o_.remind_mails);
/* 658 */       this.thank_mails = new HashSet();
/* 659 */       this.thank_mails.addAll(_o_.thank_mails);
/* 660 */       this.get_red_packet = _o_.get_red_packet;
/* 661 */       this.can_get_red_packet = _o_.can_get_red_packet;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 666 */       this.remind_mails = new HashSet();
/* 667 */       this.remind_mails.addAll(_o_.remind_mails);
/* 668 */       this.thank_mails = new HashSet();
/* 669 */       this.thank_mails.addAll(_o_.thank_mails);
/* 670 */       this.get_red_packet = _o_.get_red_packet;
/* 671 */       this.can_get_red_packet = _o_.can_get_red_packet;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 677 */       _os_.compact_uint32(this.remind_mails.size());
/* 678 */       for (Integer _v_ : this.remind_mails)
/*     */       {
/* 680 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 682 */       _os_.compact_uint32(this.thank_mails.size());
/* 683 */       for (Integer _v_ : this.thank_mails)
/*     */       {
/* 685 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 687 */       _os_.marshal(this.get_red_packet);
/* 688 */       _os_.marshal(this.can_get_red_packet);
/* 689 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 695 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 697 */         int _v_ = 0;
/* 698 */         _v_ = _os_.unmarshal_int();
/* 699 */         this.remind_mails.add(Integer.valueOf(_v_));
/*     */       }
/* 701 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 703 */         int _v_ = 0;
/* 704 */         _v_ = _os_.unmarshal_int();
/* 705 */         this.thank_mails.add(Integer.valueOf(_v_));
/*     */       }
/* 707 */       this.get_red_packet = _os_.unmarshal_boolean();
/* 708 */       this.can_get_red_packet = _os_.unmarshal_boolean();
/* 709 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 715 */       int _size_ = 0;
/* 716 */       for (Integer _v_ : this.remind_mails)
/*     */       {
/* 718 */         _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */       }
/* 720 */       for (Integer _v_ : this.thank_mails)
/*     */       {
/* 722 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 724 */       _size_ += CodedOutputStream.computeBoolSize(3, this.get_red_packet);
/* 725 */       _size_ += CodedOutputStream.computeBoolSize(4, this.can_get_red_packet);
/* 726 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 734 */         for (Integer _v_ : this.remind_mails)
/*     */         {
/* 736 */           _output_.writeInt32(1, _v_.intValue());
/*     */         }
/* 738 */         for (Integer _v_ : this.thank_mails)
/*     */         {
/* 740 */           _output_.writeInt32(2, _v_.intValue());
/*     */         }
/* 742 */         _output_.writeBool(3, this.get_red_packet);
/* 743 */         _output_.writeBool(4, this.can_get_red_packet);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 747 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 749 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 757 */         boolean done = false;
/* 758 */         while (!done)
/*     */         {
/* 760 */           int tag = _input_.readTag();
/* 761 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 765 */             done = true;
/* 766 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 770 */             int _v_ = 0;
/* 771 */             _v_ = _input_.readInt32();
/* 772 */             this.remind_mails.add(Integer.valueOf(_v_));
/* 773 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 777 */             int _v_ = 0;
/* 778 */             _v_ = _input_.readInt32();
/* 779 */             this.thank_mails.add(Integer.valueOf(_v_));
/* 780 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 784 */             this.get_red_packet = _input_.readBool();
/* 785 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 789 */             this.can_get_red_packet = _input_.readBool();
/* 790 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 794 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 796 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 805 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 809 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 811 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CountDownInfo copy()
/*     */     {
/* 817 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CountDownInfo toData()
/*     */     {
/* 823 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CountDownInfo toBean()
/*     */     {
/* 828 */       return new CountDownInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CountDownInfo toDataIf()
/*     */     {
/* 834 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CountDownInfo toBeanIf()
/*     */     {
/* 839 */       return new CountDownInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 845 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 849 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 853 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 857 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 861 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 865 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 869 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getRemind_mails()
/*     */     {
/* 876 */       return this.remind_mails;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getRemind_mailsAsData()
/*     */     {
/* 883 */       return this.remind_mails;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getThank_mails()
/*     */     {
/* 890 */       return this.thank_mails;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getThank_mailsAsData()
/*     */     {
/* 897 */       return this.thank_mails;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getGet_red_packet()
/*     */     {
/* 904 */       return this.get_red_packet;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getCan_get_red_packet()
/*     */     {
/* 911 */       return this.can_get_red_packet;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGet_red_packet(boolean _v_)
/*     */     {
/* 918 */       this.get_red_packet = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCan_get_red_packet(boolean _v_)
/*     */     {
/* 925 */       this.can_get_red_packet = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 931 */       if (!(_o1_ instanceof Data)) return false;
/* 932 */       Data _o_ = (Data)_o1_;
/* 933 */       if (!this.remind_mails.equals(_o_.remind_mails)) return false;
/* 934 */       if (!this.thank_mails.equals(_o_.thank_mails)) return false;
/* 935 */       if (this.get_red_packet != _o_.get_red_packet) return false;
/* 936 */       if (this.can_get_red_packet != _o_.can_get_red_packet) return false;
/* 937 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 943 */       int _h_ = 0;
/* 944 */       _h_ += this.remind_mails.hashCode();
/* 945 */       _h_ += this.thank_mails.hashCode();
/* 946 */       _h_ += (this.get_red_packet ? 1231 : 1237);
/* 947 */       _h_ += (this.can_get_red_packet ? 1231 : 1237);
/* 948 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 954 */       StringBuilder _sb_ = new StringBuilder();
/* 955 */       _sb_.append("(");
/* 956 */       _sb_.append(this.remind_mails);
/* 957 */       _sb_.append(",");
/* 958 */       _sb_.append(this.thank_mails);
/* 959 */       _sb_.append(",");
/* 960 */       _sb_.append(this.get_red_packet);
/* 961 */       _sb_.append(",");
/* 962 */       _sb_.append(this.can_get_red_packet);
/* 963 */       _sb_.append(")");
/* 964 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CountDownInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */