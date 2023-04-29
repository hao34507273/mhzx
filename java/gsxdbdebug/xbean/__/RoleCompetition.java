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
/*     */ 
/*     */ public final class RoleCompetition extends XBean implements xbean.RoleCompetition
/*     */ {
/*     */   private int action_point;
/*     */   private int win_streak;
/*     */   private boolean participated;
/*     */   private boolean awarded_final;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.action_point = 0;
/*  25 */     this.win_streak = 0;
/*  26 */     this.participated = false;
/*  27 */     this.awarded_final = false;
/*     */   }
/*     */   
/*     */   RoleCompetition(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.action_point = 0;
/*  34 */     this.win_streak = 0;
/*  35 */     this.participated = false;
/*  36 */     this.awarded_final = false;
/*     */   }
/*     */   
/*     */   public RoleCompetition()
/*     */   {
/*  41 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleCompetition(RoleCompetition _o_)
/*     */   {
/*  46 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleCompetition(xbean.RoleCompetition _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  51 */     super(_xp_, _vn_);
/*  52 */     if ((_o1_ instanceof RoleCompetition)) { assign((RoleCompetition)_o1_);
/*  53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  55 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleCompetition _o_) {
/*  60 */     _o_._xdb_verify_unsafe_();
/*  61 */     this.action_point = _o_.action_point;
/*  62 */     this.win_streak = _o_.win_streak;
/*  63 */     this.participated = _o_.participated;
/*  64 */     this.awarded_final = _o_.awarded_final;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.action_point = _o_.action_point;
/*  70 */     this.win_streak = _o_.win_streak;
/*  71 */     this.participated = _o_.participated;
/*  72 */     this.awarded_final = _o_.awarded_final;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  78 */     _xdb_verify_unsafe_();
/*  79 */     _os_.marshal(this.action_point);
/*  80 */     _os_.marshal(this.win_streak);
/*  81 */     _os_.marshal(this.participated);
/*  82 */     _os_.marshal(this.awarded_final);
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     this.action_point = _os_.unmarshal_int();
/*  91 */     this.win_streak = _os_.unmarshal_int();
/*  92 */     this.participated = _os_.unmarshal_boolean();
/*  93 */     this.awarded_final = _os_.unmarshal_boolean();
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/* 101 */     int _size_ = 0;
/* 102 */     _size_ += CodedOutputStream.computeInt32Size(1, this.action_point);
/* 103 */     _size_ += CodedOutputStream.computeInt32Size(2, this.win_streak);
/* 104 */     _size_ += CodedOutputStream.computeBoolSize(3, this.participated);
/* 105 */     _size_ += CodedOutputStream.computeBoolSize(4, this.awarded_final);
/* 106 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 112 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 115 */       _output_.writeInt32(1, this.action_point);
/* 116 */       _output_.writeInt32(2, this.win_streak);
/* 117 */       _output_.writeBool(3, this.participated);
/* 118 */       _output_.writeBool(4, this.awarded_final);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 122 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 124 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 130 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 133 */       boolean done = false;
/* 134 */       while (!done)
/*     */       {
/* 136 */         int tag = _input_.readTag();
/* 137 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 141 */           done = true;
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 146 */           this.action_point = _input_.readInt32();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 151 */           this.win_streak = _input_.readInt32();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 156 */           this.participated = _input_.readBool();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 161 */           this.awarded_final = _input_.readBool();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 166 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 168 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 177 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 181 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 183 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleCompetition copy()
/*     */   {
/* 189 */     _xdb_verify_unsafe_();
/* 190 */     return new RoleCompetition(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleCompetition toData()
/*     */   {
/* 196 */     _xdb_verify_unsafe_();
/* 197 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleCompetition toBean()
/*     */   {
/* 202 */     _xdb_verify_unsafe_();
/* 203 */     return new RoleCompetition(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleCompetition toDataIf()
/*     */   {
/* 209 */     _xdb_verify_unsafe_();
/* 210 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleCompetition toBeanIf()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAction_point()
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     return this.action_point;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getWin_streak()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this.win_streak;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getParticipated()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return this.participated;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getAwarded_final()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return this.awarded_final;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAction_point(int _v_)
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/* 263 */     xdb.Logs.logIf(new LogKey(this, "action_point")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 267 */         new xdb.logs.LogInt(this, RoleCompetition.this.action_point)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 271 */             RoleCompetition.this.action_point = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 275 */     });
/* 276 */     this.action_point = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWin_streak(int _v_)
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     xdb.Logs.logIf(new LogKey(this, "win_streak")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 288 */         new xdb.logs.LogInt(this, RoleCompetition.this.win_streak)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 292 */             RoleCompetition.this.win_streak = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 296 */     });
/* 297 */     this.win_streak = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setParticipated(boolean _v_)
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     xdb.Logs.logIf(new LogKey(this, "participated")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 309 */         new xdb.logs.LogObject(this, Boolean.valueOf(RoleCompetition.this.participated))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 313 */             RoleCompetition.this.participated = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 317 */     });
/* 318 */     this.participated = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAwarded_final(boolean _v_)
/*     */   {
/* 325 */     _xdb_verify_unsafe_();
/* 326 */     xdb.Logs.logIf(new LogKey(this, "awarded_final")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 330 */         new xdb.logs.LogObject(this, Boolean.valueOf(RoleCompetition.this.awarded_final))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 334 */             RoleCompetition.this.awarded_final = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 338 */     });
/* 339 */     this.awarded_final = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     RoleCompetition _o_ = null;
/* 347 */     if ((_o1_ instanceof RoleCompetition)) { _o_ = (RoleCompetition)_o1_;
/* 348 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 349 */       return false;
/* 350 */     if (this.action_point != _o_.action_point) return false;
/* 351 */     if (this.win_streak != _o_.win_streak) return false;
/* 352 */     if (this.participated != _o_.participated) return false;
/* 353 */     if (this.awarded_final != _o_.awarded_final) return false;
/* 354 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 360 */     _xdb_verify_unsafe_();
/* 361 */     int _h_ = 0;
/* 362 */     _h_ += this.action_point;
/* 363 */     _h_ += this.win_streak;
/* 364 */     _h_ += (this.participated ? 1231 : 1237);
/* 365 */     _h_ += (this.awarded_final ? 1231 : 1237);
/* 366 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 372 */     _xdb_verify_unsafe_();
/* 373 */     StringBuilder _sb_ = new StringBuilder();
/* 374 */     _sb_.append("(");
/* 375 */     _sb_.append(this.action_point);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.win_streak);
/* 378 */     _sb_.append(",");
/* 379 */     _sb_.append(this.participated);
/* 380 */     _sb_.append(",");
/* 381 */     _sb_.append(this.awarded_final);
/* 382 */     _sb_.append(")");
/* 383 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 389 */     ListenableBean lb = new ListenableBean();
/* 390 */     lb.add(new ListenableChanged().setVarName("action_point"));
/* 391 */     lb.add(new ListenableChanged().setVarName("win_streak"));
/* 392 */     lb.add(new ListenableChanged().setVarName("participated"));
/* 393 */     lb.add(new ListenableChanged().setVarName("awarded_final"));
/* 394 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleCompetition {
/*     */     private Const() {}
/*     */     
/*     */     RoleCompetition nThis() {
/* 401 */       return RoleCompetition.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 407 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleCompetition copy()
/*     */     {
/* 413 */       return RoleCompetition.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleCompetition toData()
/*     */     {
/* 419 */       return RoleCompetition.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleCompetition toBean()
/*     */     {
/* 424 */       return RoleCompetition.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleCompetition toDataIf()
/*     */     {
/* 430 */       return RoleCompetition.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleCompetition toBeanIf()
/*     */     {
/* 435 */       return RoleCompetition.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAction_point()
/*     */     {
/* 442 */       RoleCompetition.this._xdb_verify_unsafe_();
/* 443 */       return RoleCompetition.this.action_point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getWin_streak()
/*     */     {
/* 450 */       RoleCompetition.this._xdb_verify_unsafe_();
/* 451 */       return RoleCompetition.this.win_streak;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getParticipated()
/*     */     {
/* 458 */       RoleCompetition.this._xdb_verify_unsafe_();
/* 459 */       return RoleCompetition.this.participated;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getAwarded_final()
/*     */     {
/* 466 */       RoleCompetition.this._xdb_verify_unsafe_();
/* 467 */       return RoleCompetition.this.awarded_final;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAction_point(int _v_)
/*     */     {
/* 474 */       RoleCompetition.this._xdb_verify_unsafe_();
/* 475 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWin_streak(int _v_)
/*     */     {
/* 482 */       RoleCompetition.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setParticipated(boolean _v_)
/*     */     {
/* 490 */       RoleCompetition.this._xdb_verify_unsafe_();
/* 491 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwarded_final(boolean _v_)
/*     */     {
/* 498 */       RoleCompetition.this._xdb_verify_unsafe_();
/* 499 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 505 */       RoleCompetition.this._xdb_verify_unsafe_();
/* 506 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 512 */       RoleCompetition.this._xdb_verify_unsafe_();
/* 513 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 519 */       return RoleCompetition.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 525 */       return RoleCompetition.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 531 */       RoleCompetition.this._xdb_verify_unsafe_();
/* 532 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 538 */       return RoleCompetition.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 544 */       return RoleCompetition.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 550 */       RoleCompetition.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 557 */       return RoleCompetition.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 563 */       return RoleCompetition.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 569 */       return RoleCompetition.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 575 */       return RoleCompetition.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 581 */       return RoleCompetition.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 587 */       return RoleCompetition.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 593 */       return RoleCompetition.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleCompetition
/*     */   {
/*     */     private int action_point;
/*     */     
/*     */     private int win_streak;
/*     */     
/*     */     private boolean participated;
/*     */     
/*     */     private boolean awarded_final;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 611 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 616 */       this.action_point = 0;
/* 617 */       this.win_streak = 0;
/* 618 */       this.participated = false;
/* 619 */       this.awarded_final = false;
/*     */     }
/*     */     
/*     */     Data(xbean.RoleCompetition _o1_)
/*     */     {
/* 624 */       if ((_o1_ instanceof RoleCompetition)) { assign((RoleCompetition)_o1_);
/* 625 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 626 */       } else if ((_o1_ instanceof RoleCompetition.Const)) assign(((RoleCompetition.Const)_o1_).nThis()); else {
/* 627 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleCompetition _o_) {
/* 632 */       this.action_point = _o_.action_point;
/* 633 */       this.win_streak = _o_.win_streak;
/* 634 */       this.participated = _o_.participated;
/* 635 */       this.awarded_final = _o_.awarded_final;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 640 */       this.action_point = _o_.action_point;
/* 641 */       this.win_streak = _o_.win_streak;
/* 642 */       this.participated = _o_.participated;
/* 643 */       this.awarded_final = _o_.awarded_final;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 649 */       _os_.marshal(this.action_point);
/* 650 */       _os_.marshal(this.win_streak);
/* 651 */       _os_.marshal(this.participated);
/* 652 */       _os_.marshal(this.awarded_final);
/* 653 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 659 */       this.action_point = _os_.unmarshal_int();
/* 660 */       this.win_streak = _os_.unmarshal_int();
/* 661 */       this.participated = _os_.unmarshal_boolean();
/* 662 */       this.awarded_final = _os_.unmarshal_boolean();
/* 663 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 669 */       int _size_ = 0;
/* 670 */       _size_ += CodedOutputStream.computeInt32Size(1, this.action_point);
/* 671 */       _size_ += CodedOutputStream.computeInt32Size(2, this.win_streak);
/* 672 */       _size_ += CodedOutputStream.computeBoolSize(3, this.participated);
/* 673 */       _size_ += CodedOutputStream.computeBoolSize(4, this.awarded_final);
/* 674 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 682 */         _output_.writeInt32(1, this.action_point);
/* 683 */         _output_.writeInt32(2, this.win_streak);
/* 684 */         _output_.writeBool(3, this.participated);
/* 685 */         _output_.writeBool(4, this.awarded_final);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 689 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 691 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 699 */         boolean done = false;
/* 700 */         while (!done)
/*     */         {
/* 702 */           int tag = _input_.readTag();
/* 703 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 707 */             done = true;
/* 708 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 712 */             this.action_point = _input_.readInt32();
/* 713 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 717 */             this.win_streak = _input_.readInt32();
/* 718 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 722 */             this.participated = _input_.readBool();
/* 723 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 727 */             this.awarded_final = _input_.readBool();
/* 728 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 732 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 734 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 743 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 747 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 749 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleCompetition copy()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleCompetition toData()
/*     */     {
/* 761 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleCompetition toBean()
/*     */     {
/* 766 */       return new RoleCompetition(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleCompetition toDataIf()
/*     */     {
/* 772 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleCompetition toBeanIf()
/*     */     {
/* 777 */       return new RoleCompetition(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 795 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 799 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 803 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 807 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAction_point()
/*     */     {
/* 814 */       return this.action_point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getWin_streak()
/*     */     {
/* 821 */       return this.win_streak;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getParticipated()
/*     */     {
/* 828 */       return this.participated;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getAwarded_final()
/*     */     {
/* 835 */       return this.awarded_final;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAction_point(int _v_)
/*     */     {
/* 842 */       this.action_point = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWin_streak(int _v_)
/*     */     {
/* 849 */       this.win_streak = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setParticipated(boolean _v_)
/*     */     {
/* 856 */       this.participated = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwarded_final(boolean _v_)
/*     */     {
/* 863 */       this.awarded_final = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 869 */       if (!(_o1_ instanceof Data)) return false;
/* 870 */       Data _o_ = (Data)_o1_;
/* 871 */       if (this.action_point != _o_.action_point) return false;
/* 872 */       if (this.win_streak != _o_.win_streak) return false;
/* 873 */       if (this.participated != _o_.participated) return false;
/* 874 */       if (this.awarded_final != _o_.awarded_final) return false;
/* 875 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 881 */       int _h_ = 0;
/* 882 */       _h_ += this.action_point;
/* 883 */       _h_ += this.win_streak;
/* 884 */       _h_ += (this.participated ? 1231 : 1237);
/* 885 */       _h_ += (this.awarded_final ? 1231 : 1237);
/* 886 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 892 */       StringBuilder _sb_ = new StringBuilder();
/* 893 */       _sb_.append("(");
/* 894 */       _sb_.append(this.action_point);
/* 895 */       _sb_.append(",");
/* 896 */       _sb_.append(this.win_streak);
/* 897 */       _sb_.append(",");
/* 898 */       _sb_.append(this.participated);
/* 899 */       _sb_.append(",");
/* 900 */       _sb_.append(this.awarded_final);
/* 901 */       _sb_.append(")");
/* 902 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleCompetition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */