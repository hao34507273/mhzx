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
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class RoleSingleCrossFieldSeasonInfo extends XBean implements xbean.RoleSingleCrossFieldSeasonInfo
/*     */ {
/*     */   private int star_num;
/*     */   private int win_point;
/*     */   private int straight_win_num;
/*     */   private long star_num_timestamp;
/*     */   private boolean awarded;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.star_num = 0;
/*  27 */     this.win_point = 0;
/*  28 */     this.straight_win_num = 0;
/*  29 */     this.star_num_timestamp = 0L;
/*  30 */     this.awarded = false;
/*     */   }
/*     */   
/*     */   RoleSingleCrossFieldSeasonInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*  36 */     this.star_num = 0;
/*  37 */     this.win_point = 0;
/*  38 */     this.straight_win_num = 0;
/*  39 */     this.star_num_timestamp = 0L;
/*  40 */     this.awarded = false;
/*     */   }
/*     */   
/*     */   public RoleSingleCrossFieldSeasonInfo()
/*     */   {
/*  45 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleSingleCrossFieldSeasonInfo(RoleSingleCrossFieldSeasonInfo _o_)
/*     */   {
/*  50 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleSingleCrossFieldSeasonInfo(xbean.RoleSingleCrossFieldSeasonInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  55 */     super(_xp_, _vn_);
/*  56 */     if ((_o1_ instanceof RoleSingleCrossFieldSeasonInfo)) { assign((RoleSingleCrossFieldSeasonInfo)_o1_);
/*  57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  59 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleSingleCrossFieldSeasonInfo _o_) {
/*  64 */     _o_._xdb_verify_unsafe_();
/*  65 */     this.star_num = _o_.star_num;
/*  66 */     this.win_point = _o_.win_point;
/*  67 */     this.straight_win_num = _o_.straight_win_num;
/*  68 */     this.star_num_timestamp = _o_.star_num_timestamp;
/*  69 */     this.awarded = _o_.awarded;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  74 */     this.star_num = _o_.star_num;
/*  75 */     this.win_point = _o_.win_point;
/*  76 */     this.straight_win_num = _o_.straight_win_num;
/*  77 */     this.star_num_timestamp = _o_.star_num_timestamp;
/*  78 */     this.awarded = _o_.awarded;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     _os_.marshal(this.star_num);
/*  86 */     _os_.marshal(this.win_point);
/*  87 */     _os_.marshal(this.straight_win_num);
/*  88 */     _os_.marshal(this.star_num_timestamp);
/*  89 */     _os_.marshal(this.awarded);
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     this.star_num = _os_.unmarshal_int();
/*  98 */     this.win_point = _os_.unmarshal_int();
/*  99 */     this.straight_win_num = _os_.unmarshal_int();
/* 100 */     this.star_num_timestamp = _os_.unmarshal_long();
/* 101 */     this.awarded = _os_.unmarshal_boolean();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/* 109 */     int _size_ = 0;
/* 110 */     _size_ += CodedOutputStream.computeInt32Size(1, this.star_num);
/* 111 */     _size_ += CodedOutputStream.computeInt32Size(2, this.win_point);
/* 112 */     _size_ += CodedOutputStream.computeInt32Size(3, this.straight_win_num);
/* 113 */     _size_ += CodedOutputStream.computeInt64Size(4, this.star_num_timestamp);
/* 114 */     _size_ += CodedOutputStream.computeBoolSize(5, this.awarded);
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       _output_.writeInt32(1, this.star_num);
/* 125 */       _output_.writeInt32(2, this.win_point);
/* 126 */       _output_.writeInt32(3, this.straight_win_num);
/* 127 */       _output_.writeInt64(4, this.star_num_timestamp);
/* 128 */       _output_.writeBool(5, this.awarded);
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
/* 156 */           this.star_num = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 161 */           this.win_point = _input_.readInt32();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 166 */           this.straight_win_num = _input_.readInt32();
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 171 */           this.star_num_timestamp = _input_.readInt64();
/* 172 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 176 */           this.awarded = _input_.readBool();
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
/*     */   public xbean.RoleSingleCrossFieldSeasonInfo copy()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new RoleSingleCrossFieldSeasonInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleSingleCrossFieldSeasonInfo toData()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleSingleCrossFieldSeasonInfo toBean()
/*     */   {
/* 217 */     _xdb_verify_unsafe_();
/* 218 */     return new RoleSingleCrossFieldSeasonInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleSingleCrossFieldSeasonInfo toDataIf()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleSingleCrossFieldSeasonInfo toBeanIf()
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
/*     */   public int getStar_num()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return this.star_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getWin_point()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this.win_point;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getStraight_win_num()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.straight_win_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStar_num_timestamp()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return this.star_num_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getAwarded()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/* 278 */     return this.awarded;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStar_num(int _v_)
/*     */   {
/* 285 */     _xdb_verify_unsafe_();
/* 286 */     xdb.Logs.logIf(new LogKey(this, "star_num")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 290 */         new LogInt(this, RoleSingleCrossFieldSeasonInfo.this.star_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 294 */             RoleSingleCrossFieldSeasonInfo.this.star_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 298 */     });
/* 299 */     this.star_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWin_point(int _v_)
/*     */   {
/* 306 */     _xdb_verify_unsafe_();
/* 307 */     xdb.Logs.logIf(new LogKey(this, "win_point")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 311 */         new LogInt(this, RoleSingleCrossFieldSeasonInfo.this.win_point)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 315 */             RoleSingleCrossFieldSeasonInfo.this.win_point = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 319 */     });
/* 320 */     this.win_point = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStraight_win_num(int _v_)
/*     */   {
/* 327 */     _xdb_verify_unsafe_();
/* 328 */     xdb.Logs.logIf(new LogKey(this, "straight_win_num")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 332 */         new LogInt(this, RoleSingleCrossFieldSeasonInfo.this.straight_win_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 336 */             RoleSingleCrossFieldSeasonInfo.this.straight_win_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 340 */     });
/* 341 */     this.straight_win_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStar_num_timestamp(long _v_)
/*     */   {
/* 348 */     _xdb_verify_unsafe_();
/* 349 */     xdb.Logs.logIf(new LogKey(this, "star_num_timestamp")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 353 */         new xdb.logs.LogLong(this, RoleSingleCrossFieldSeasonInfo.this.star_num_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 357 */             RoleSingleCrossFieldSeasonInfo.this.star_num_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 361 */     });
/* 362 */     this.star_num_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAwarded(boolean _v_)
/*     */   {
/* 369 */     _xdb_verify_unsafe_();
/* 370 */     xdb.Logs.logIf(new LogKey(this, "awarded")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 374 */         new xdb.logs.LogObject(this, Boolean.valueOf(RoleSingleCrossFieldSeasonInfo.this.awarded))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 378 */             RoleSingleCrossFieldSeasonInfo.this.awarded = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 382 */     });
/* 383 */     this.awarded = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     RoleSingleCrossFieldSeasonInfo _o_ = null;
/* 391 */     if ((_o1_ instanceof RoleSingleCrossFieldSeasonInfo)) { _o_ = (RoleSingleCrossFieldSeasonInfo)_o1_;
/* 392 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 393 */       return false;
/* 394 */     if (this.star_num != _o_.star_num) return false;
/* 395 */     if (this.win_point != _o_.win_point) return false;
/* 396 */     if (this.straight_win_num != _o_.straight_win_num) return false;
/* 397 */     if (this.star_num_timestamp != _o_.star_num_timestamp) return false;
/* 398 */     if (this.awarded != _o_.awarded) return false;
/* 399 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 405 */     _xdb_verify_unsafe_();
/* 406 */     int _h_ = 0;
/* 407 */     _h_ += this.star_num;
/* 408 */     _h_ += this.win_point;
/* 409 */     _h_ += this.straight_win_num;
/* 410 */     _h_ = (int)(_h_ + this.star_num_timestamp);
/* 411 */     _h_ += (this.awarded ? 1231 : 1237);
/* 412 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 418 */     _xdb_verify_unsafe_();
/* 419 */     StringBuilder _sb_ = new StringBuilder();
/* 420 */     _sb_.append("(");
/* 421 */     _sb_.append(this.star_num);
/* 422 */     _sb_.append(",");
/* 423 */     _sb_.append(this.win_point);
/* 424 */     _sb_.append(",");
/* 425 */     _sb_.append(this.straight_win_num);
/* 426 */     _sb_.append(",");
/* 427 */     _sb_.append(this.star_num_timestamp);
/* 428 */     _sb_.append(",");
/* 429 */     _sb_.append(this.awarded);
/* 430 */     _sb_.append(")");
/* 431 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 437 */     ListenableBean lb = new ListenableBean();
/* 438 */     lb.add(new ListenableChanged().setVarName("star_num"));
/* 439 */     lb.add(new ListenableChanged().setVarName("win_point"));
/* 440 */     lb.add(new ListenableChanged().setVarName("straight_win_num"));
/* 441 */     lb.add(new ListenableChanged().setVarName("star_num_timestamp"));
/* 442 */     lb.add(new ListenableChanged().setVarName("awarded"));
/* 443 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleSingleCrossFieldSeasonInfo {
/*     */     private Const() {}
/*     */     
/*     */     RoleSingleCrossFieldSeasonInfo nThis() {
/* 450 */       return RoleSingleCrossFieldSeasonInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 456 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldSeasonInfo copy()
/*     */     {
/* 462 */       return RoleSingleCrossFieldSeasonInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldSeasonInfo toData()
/*     */     {
/* 468 */       return RoleSingleCrossFieldSeasonInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleSingleCrossFieldSeasonInfo toBean()
/*     */     {
/* 473 */       return RoleSingleCrossFieldSeasonInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldSeasonInfo toDataIf()
/*     */     {
/* 479 */       return RoleSingleCrossFieldSeasonInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleSingleCrossFieldSeasonInfo toBeanIf()
/*     */     {
/* 484 */       return RoleSingleCrossFieldSeasonInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStar_num()
/*     */     {
/* 491 */       RoleSingleCrossFieldSeasonInfo.this._xdb_verify_unsafe_();
/* 492 */       return RoleSingleCrossFieldSeasonInfo.this.star_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getWin_point()
/*     */     {
/* 499 */       RoleSingleCrossFieldSeasonInfo.this._xdb_verify_unsafe_();
/* 500 */       return RoleSingleCrossFieldSeasonInfo.this.win_point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStraight_win_num()
/*     */     {
/* 507 */       RoleSingleCrossFieldSeasonInfo.this._xdb_verify_unsafe_();
/* 508 */       return RoleSingleCrossFieldSeasonInfo.this.straight_win_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStar_num_timestamp()
/*     */     {
/* 515 */       RoleSingleCrossFieldSeasonInfo.this._xdb_verify_unsafe_();
/* 516 */       return RoleSingleCrossFieldSeasonInfo.this.star_num_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getAwarded()
/*     */     {
/* 523 */       RoleSingleCrossFieldSeasonInfo.this._xdb_verify_unsafe_();
/* 524 */       return RoleSingleCrossFieldSeasonInfo.this.awarded;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStar_num(int _v_)
/*     */     {
/* 531 */       RoleSingleCrossFieldSeasonInfo.this._xdb_verify_unsafe_();
/* 532 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWin_point(int _v_)
/*     */     {
/* 539 */       RoleSingleCrossFieldSeasonInfo.this._xdb_verify_unsafe_();
/* 540 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStraight_win_num(int _v_)
/*     */     {
/* 547 */       RoleSingleCrossFieldSeasonInfo.this._xdb_verify_unsafe_();
/* 548 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStar_num_timestamp(long _v_)
/*     */     {
/* 555 */       RoleSingleCrossFieldSeasonInfo.this._xdb_verify_unsafe_();
/* 556 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwarded(boolean _v_)
/*     */     {
/* 563 */       RoleSingleCrossFieldSeasonInfo.this._xdb_verify_unsafe_();
/* 564 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 570 */       RoleSingleCrossFieldSeasonInfo.this._xdb_verify_unsafe_();
/* 571 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 577 */       RoleSingleCrossFieldSeasonInfo.this._xdb_verify_unsafe_();
/* 578 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 584 */       return RoleSingleCrossFieldSeasonInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 590 */       return RoleSingleCrossFieldSeasonInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 596 */       RoleSingleCrossFieldSeasonInfo.this._xdb_verify_unsafe_();
/* 597 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 603 */       return RoleSingleCrossFieldSeasonInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 609 */       return RoleSingleCrossFieldSeasonInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 615 */       RoleSingleCrossFieldSeasonInfo.this._xdb_verify_unsafe_();
/* 616 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 622 */       return RoleSingleCrossFieldSeasonInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 628 */       return RoleSingleCrossFieldSeasonInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 634 */       return RoleSingleCrossFieldSeasonInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 640 */       return RoleSingleCrossFieldSeasonInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 646 */       return RoleSingleCrossFieldSeasonInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 652 */       return RoleSingleCrossFieldSeasonInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 658 */       return RoleSingleCrossFieldSeasonInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleSingleCrossFieldSeasonInfo
/*     */   {
/*     */     private int star_num;
/*     */     
/*     */     private int win_point;
/*     */     
/*     */     private int straight_win_num;
/*     */     
/*     */     private long star_num_timestamp;
/*     */     
/*     */     private boolean awarded;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 678 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 683 */       this.star_num = 0;
/* 684 */       this.win_point = 0;
/* 685 */       this.straight_win_num = 0;
/* 686 */       this.star_num_timestamp = 0L;
/* 687 */       this.awarded = false;
/*     */     }
/*     */     
/*     */     Data(xbean.RoleSingleCrossFieldSeasonInfo _o1_)
/*     */     {
/* 692 */       if ((_o1_ instanceof RoleSingleCrossFieldSeasonInfo)) { assign((RoleSingleCrossFieldSeasonInfo)_o1_);
/* 693 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 694 */       } else if ((_o1_ instanceof RoleSingleCrossFieldSeasonInfo.Const)) assign(((RoleSingleCrossFieldSeasonInfo.Const)_o1_).nThis()); else {
/* 695 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleSingleCrossFieldSeasonInfo _o_) {
/* 700 */       this.star_num = _o_.star_num;
/* 701 */       this.win_point = _o_.win_point;
/* 702 */       this.straight_win_num = _o_.straight_win_num;
/* 703 */       this.star_num_timestamp = _o_.star_num_timestamp;
/* 704 */       this.awarded = _o_.awarded;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 709 */       this.star_num = _o_.star_num;
/* 710 */       this.win_point = _o_.win_point;
/* 711 */       this.straight_win_num = _o_.straight_win_num;
/* 712 */       this.star_num_timestamp = _o_.star_num_timestamp;
/* 713 */       this.awarded = _o_.awarded;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 719 */       _os_.marshal(this.star_num);
/* 720 */       _os_.marshal(this.win_point);
/* 721 */       _os_.marshal(this.straight_win_num);
/* 722 */       _os_.marshal(this.star_num_timestamp);
/* 723 */       _os_.marshal(this.awarded);
/* 724 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 730 */       this.star_num = _os_.unmarshal_int();
/* 731 */       this.win_point = _os_.unmarshal_int();
/* 732 */       this.straight_win_num = _os_.unmarshal_int();
/* 733 */       this.star_num_timestamp = _os_.unmarshal_long();
/* 734 */       this.awarded = _os_.unmarshal_boolean();
/* 735 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 741 */       int _size_ = 0;
/* 742 */       _size_ += CodedOutputStream.computeInt32Size(1, this.star_num);
/* 743 */       _size_ += CodedOutputStream.computeInt32Size(2, this.win_point);
/* 744 */       _size_ += CodedOutputStream.computeInt32Size(3, this.straight_win_num);
/* 745 */       _size_ += CodedOutputStream.computeInt64Size(4, this.star_num_timestamp);
/* 746 */       _size_ += CodedOutputStream.computeBoolSize(5, this.awarded);
/* 747 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 755 */         _output_.writeInt32(1, this.star_num);
/* 756 */         _output_.writeInt32(2, this.win_point);
/* 757 */         _output_.writeInt32(3, this.straight_win_num);
/* 758 */         _output_.writeInt64(4, this.star_num_timestamp);
/* 759 */         _output_.writeBool(5, this.awarded);
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
/* 786 */             this.star_num = _input_.readInt32();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 791 */             this.win_point = _input_.readInt32();
/* 792 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 796 */             this.straight_win_num = _input_.readInt32();
/* 797 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 801 */             this.star_num_timestamp = _input_.readInt64();
/* 802 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 806 */             this.awarded = _input_.readBool();
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
/*     */     public xbean.RoleSingleCrossFieldSeasonInfo copy()
/*     */     {
/* 834 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldSeasonInfo toData()
/*     */     {
/* 840 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleSingleCrossFieldSeasonInfo toBean()
/*     */     {
/* 845 */       return new RoleSingleCrossFieldSeasonInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleSingleCrossFieldSeasonInfo toDataIf()
/*     */     {
/* 851 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleSingleCrossFieldSeasonInfo toBeanIf()
/*     */     {
/* 856 */       return new RoleSingleCrossFieldSeasonInfo(this, null, null);
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
/*     */     public int getStar_num()
/*     */     {
/* 893 */       return this.star_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getWin_point()
/*     */     {
/* 900 */       return this.win_point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStraight_win_num()
/*     */     {
/* 907 */       return this.straight_win_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStar_num_timestamp()
/*     */     {
/* 914 */       return this.star_num_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getAwarded()
/*     */     {
/* 921 */       return this.awarded;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStar_num(int _v_)
/*     */     {
/* 928 */       this.star_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWin_point(int _v_)
/*     */     {
/* 935 */       this.win_point = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStraight_win_num(int _v_)
/*     */     {
/* 942 */       this.straight_win_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStar_num_timestamp(long _v_)
/*     */     {
/* 949 */       this.star_num_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwarded(boolean _v_)
/*     */     {
/* 956 */       this.awarded = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 962 */       if (!(_o1_ instanceof Data)) return false;
/* 963 */       Data _o_ = (Data)_o1_;
/* 964 */       if (this.star_num != _o_.star_num) return false;
/* 965 */       if (this.win_point != _o_.win_point) return false;
/* 966 */       if (this.straight_win_num != _o_.straight_win_num) return false;
/* 967 */       if (this.star_num_timestamp != _o_.star_num_timestamp) return false;
/* 968 */       if (this.awarded != _o_.awarded) return false;
/* 969 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 975 */       int _h_ = 0;
/* 976 */       _h_ += this.star_num;
/* 977 */       _h_ += this.win_point;
/* 978 */       _h_ += this.straight_win_num;
/* 979 */       _h_ = (int)(_h_ + this.star_num_timestamp);
/* 980 */       _h_ += (this.awarded ? 1231 : 1237);
/* 981 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 987 */       StringBuilder _sb_ = new StringBuilder();
/* 988 */       _sb_.append("(");
/* 989 */       _sb_.append(this.star_num);
/* 990 */       _sb_.append(",");
/* 991 */       _sb_.append(this.win_point);
/* 992 */       _sb_.append(",");
/* 993 */       _sb_.append(this.straight_win_num);
/* 994 */       _sb_.append(",");
/* 995 */       _sb_.append(this.star_num_timestamp);
/* 996 */       _sb_.append(",");
/* 997 */       _sb_.append(this.awarded);
/* 998 */       _sb_.append(")");
/* 999 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleSingleCrossFieldSeasonInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */