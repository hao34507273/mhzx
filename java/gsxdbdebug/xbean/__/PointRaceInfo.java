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
/*     */ public final class PointRaceInfo extends XBean implements xbean.PointRaceInfo
/*     */ {
/*     */   private int win;
/*     */   private int lose;
/*     */   private int point;
/*     */   private long update_time;
/*     */   private boolean reported;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.win = 0;
/*  27 */     this.lose = 0;
/*  28 */     this.point = 0;
/*  29 */     this.update_time = 0L;
/*  30 */     this.reported = false;
/*     */   }
/*     */   
/*     */   PointRaceInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*  36 */     this.win = 0;
/*  37 */     this.lose = 0;
/*  38 */     this.point = 0;
/*  39 */     this.update_time = 0L;
/*  40 */     this.reported = false;
/*     */   }
/*     */   
/*     */   public PointRaceInfo()
/*     */   {
/*  45 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PointRaceInfo(PointRaceInfo _o_)
/*     */   {
/*  50 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PointRaceInfo(xbean.PointRaceInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  55 */     super(_xp_, _vn_);
/*  56 */     if ((_o1_ instanceof PointRaceInfo)) { assign((PointRaceInfo)_o1_);
/*  57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  59 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PointRaceInfo _o_) {
/*  64 */     _o_._xdb_verify_unsafe_();
/*  65 */     this.win = _o_.win;
/*  66 */     this.lose = _o_.lose;
/*  67 */     this.point = _o_.point;
/*  68 */     this.update_time = _o_.update_time;
/*  69 */     this.reported = _o_.reported;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  74 */     this.win = _o_.win;
/*  75 */     this.lose = _o_.lose;
/*  76 */     this.point = _o_.point;
/*  77 */     this.update_time = _o_.update_time;
/*  78 */     this.reported = _o_.reported;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     _os_.marshal(this.win);
/*  86 */     _os_.marshal(this.lose);
/*  87 */     _os_.marshal(this.point);
/*  88 */     _os_.marshal(this.update_time);
/*  89 */     _os_.marshal(this.reported);
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     this.win = _os_.unmarshal_int();
/*  98 */     this.lose = _os_.unmarshal_int();
/*  99 */     this.point = _os_.unmarshal_int();
/* 100 */     this.update_time = _os_.unmarshal_long();
/* 101 */     this.reported = _os_.unmarshal_boolean();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/* 109 */     int _size_ = 0;
/* 110 */     _size_ += CodedOutputStream.computeInt32Size(1, this.win);
/* 111 */     _size_ += CodedOutputStream.computeInt32Size(2, this.lose);
/* 112 */     _size_ += CodedOutputStream.computeInt32Size(3, this.point);
/* 113 */     _size_ += CodedOutputStream.computeInt64Size(4, this.update_time);
/* 114 */     _size_ += CodedOutputStream.computeBoolSize(5, this.reported);
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       _output_.writeInt32(1, this.win);
/* 125 */       _output_.writeInt32(2, this.lose);
/* 126 */       _output_.writeInt32(3, this.point);
/* 127 */       _output_.writeInt64(4, this.update_time);
/* 128 */       _output_.writeBool(5, this.reported);
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
/* 156 */           this.win = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 161 */           this.lose = _input_.readInt32();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 166 */           this.point = _input_.readInt32();
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 171 */           this.update_time = _input_.readInt64();
/* 172 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 176 */           this.reported = _input_.readBool();
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
/*     */   public xbean.PointRaceInfo copy()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new PointRaceInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PointRaceInfo toData()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PointRaceInfo toBean()
/*     */   {
/* 217 */     _xdb_verify_unsafe_();
/* 218 */     return new PointRaceInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PointRaceInfo toDataIf()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PointRaceInfo toBeanIf()
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
/*     */   public int getWin()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return this.win;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getLose()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this.lose;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPoint()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.point;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getUpdate_time()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return this.update_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getReported()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/* 278 */     return this.reported;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWin(int _v_)
/*     */   {
/* 285 */     _xdb_verify_unsafe_();
/* 286 */     xdb.Logs.logIf(new LogKey(this, "win")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 290 */         new LogInt(this, PointRaceInfo.this.win)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 294 */             PointRaceInfo.this.win = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 298 */     });
/* 299 */     this.win = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLose(int _v_)
/*     */   {
/* 306 */     _xdb_verify_unsafe_();
/* 307 */     xdb.Logs.logIf(new LogKey(this, "lose")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 311 */         new LogInt(this, PointRaceInfo.this.lose)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 315 */             PointRaceInfo.this.lose = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 319 */     });
/* 320 */     this.lose = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPoint(int _v_)
/*     */   {
/* 327 */     _xdb_verify_unsafe_();
/* 328 */     xdb.Logs.logIf(new LogKey(this, "point")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 332 */         new LogInt(this, PointRaceInfo.this.point)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 336 */             PointRaceInfo.this.point = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 340 */     });
/* 341 */     this.point = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUpdate_time(long _v_)
/*     */   {
/* 348 */     _xdb_verify_unsafe_();
/* 349 */     xdb.Logs.logIf(new LogKey(this, "update_time")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 353 */         new xdb.logs.LogLong(this, PointRaceInfo.this.update_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 357 */             PointRaceInfo.this.update_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 361 */     });
/* 362 */     this.update_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReported(boolean _v_)
/*     */   {
/* 369 */     _xdb_verify_unsafe_();
/* 370 */     xdb.Logs.logIf(new LogKey(this, "reported")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 374 */         new xdb.logs.LogObject(this, Boolean.valueOf(PointRaceInfo.this.reported))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 378 */             PointRaceInfo.this.reported = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 382 */     });
/* 383 */     this.reported = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     PointRaceInfo _o_ = null;
/* 391 */     if ((_o1_ instanceof PointRaceInfo)) { _o_ = (PointRaceInfo)_o1_;
/* 392 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 393 */       return false;
/* 394 */     if (this.win != _o_.win) return false;
/* 395 */     if (this.lose != _o_.lose) return false;
/* 396 */     if (this.point != _o_.point) return false;
/* 397 */     if (this.update_time != _o_.update_time) return false;
/* 398 */     if (this.reported != _o_.reported) return false;
/* 399 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 405 */     _xdb_verify_unsafe_();
/* 406 */     int _h_ = 0;
/* 407 */     _h_ += this.win;
/* 408 */     _h_ += this.lose;
/* 409 */     _h_ += this.point;
/* 410 */     _h_ = (int)(_h_ + this.update_time);
/* 411 */     _h_ += (this.reported ? 1231 : 1237);
/* 412 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 418 */     _xdb_verify_unsafe_();
/* 419 */     StringBuilder _sb_ = new StringBuilder();
/* 420 */     _sb_.append("(");
/* 421 */     _sb_.append(this.win);
/* 422 */     _sb_.append(",");
/* 423 */     _sb_.append(this.lose);
/* 424 */     _sb_.append(",");
/* 425 */     _sb_.append(this.point);
/* 426 */     _sb_.append(",");
/* 427 */     _sb_.append(this.update_time);
/* 428 */     _sb_.append(",");
/* 429 */     _sb_.append(this.reported);
/* 430 */     _sb_.append(")");
/* 431 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 437 */     ListenableBean lb = new ListenableBean();
/* 438 */     lb.add(new ListenableChanged().setVarName("win"));
/* 439 */     lb.add(new ListenableChanged().setVarName("lose"));
/* 440 */     lb.add(new ListenableChanged().setVarName("point"));
/* 441 */     lb.add(new ListenableChanged().setVarName("update_time"));
/* 442 */     lb.add(new ListenableChanged().setVarName("reported"));
/* 443 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PointRaceInfo {
/*     */     private Const() {}
/*     */     
/*     */     PointRaceInfo nThis() {
/* 450 */       return PointRaceInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 456 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PointRaceInfo copy()
/*     */     {
/* 462 */       return PointRaceInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PointRaceInfo toData()
/*     */     {
/* 468 */       return PointRaceInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PointRaceInfo toBean()
/*     */     {
/* 473 */       return PointRaceInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PointRaceInfo toDataIf()
/*     */     {
/* 479 */       return PointRaceInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PointRaceInfo toBeanIf()
/*     */     {
/* 484 */       return PointRaceInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getWin()
/*     */     {
/* 491 */       PointRaceInfo.this._xdb_verify_unsafe_();
/* 492 */       return PointRaceInfo.this.win;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLose()
/*     */     {
/* 499 */       PointRaceInfo.this._xdb_verify_unsafe_();
/* 500 */       return PointRaceInfo.this.lose;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPoint()
/*     */     {
/* 507 */       PointRaceInfo.this._xdb_verify_unsafe_();
/* 508 */       return PointRaceInfo.this.point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getUpdate_time()
/*     */     {
/* 515 */       PointRaceInfo.this._xdb_verify_unsafe_();
/* 516 */       return PointRaceInfo.this.update_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getReported()
/*     */     {
/* 523 */       PointRaceInfo.this._xdb_verify_unsafe_();
/* 524 */       return PointRaceInfo.this.reported;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWin(int _v_)
/*     */     {
/* 531 */       PointRaceInfo.this._xdb_verify_unsafe_();
/* 532 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLose(int _v_)
/*     */     {
/* 539 */       PointRaceInfo.this._xdb_verify_unsafe_();
/* 540 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPoint(int _v_)
/*     */     {
/* 547 */       PointRaceInfo.this._xdb_verify_unsafe_();
/* 548 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUpdate_time(long _v_)
/*     */     {
/* 555 */       PointRaceInfo.this._xdb_verify_unsafe_();
/* 556 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReported(boolean _v_)
/*     */     {
/* 563 */       PointRaceInfo.this._xdb_verify_unsafe_();
/* 564 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 570 */       PointRaceInfo.this._xdb_verify_unsafe_();
/* 571 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 577 */       PointRaceInfo.this._xdb_verify_unsafe_();
/* 578 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 584 */       return PointRaceInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 590 */       return PointRaceInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 596 */       PointRaceInfo.this._xdb_verify_unsafe_();
/* 597 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 603 */       return PointRaceInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 609 */       return PointRaceInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 615 */       PointRaceInfo.this._xdb_verify_unsafe_();
/* 616 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 622 */       return PointRaceInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 628 */       return PointRaceInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 634 */       return PointRaceInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 640 */       return PointRaceInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 646 */       return PointRaceInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 652 */       return PointRaceInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 658 */       return PointRaceInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PointRaceInfo
/*     */   {
/*     */     private int win;
/*     */     
/*     */     private int lose;
/*     */     
/*     */     private int point;
/*     */     
/*     */     private long update_time;
/*     */     
/*     */     private boolean reported;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 678 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 683 */       this.win = 0;
/* 684 */       this.lose = 0;
/* 685 */       this.point = 0;
/* 686 */       this.update_time = 0L;
/* 687 */       this.reported = false;
/*     */     }
/*     */     
/*     */     Data(xbean.PointRaceInfo _o1_)
/*     */     {
/* 692 */       if ((_o1_ instanceof PointRaceInfo)) { assign((PointRaceInfo)_o1_);
/* 693 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 694 */       } else if ((_o1_ instanceof PointRaceInfo.Const)) assign(((PointRaceInfo.Const)_o1_).nThis()); else {
/* 695 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PointRaceInfo _o_) {
/* 700 */       this.win = _o_.win;
/* 701 */       this.lose = _o_.lose;
/* 702 */       this.point = _o_.point;
/* 703 */       this.update_time = _o_.update_time;
/* 704 */       this.reported = _o_.reported;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 709 */       this.win = _o_.win;
/* 710 */       this.lose = _o_.lose;
/* 711 */       this.point = _o_.point;
/* 712 */       this.update_time = _o_.update_time;
/* 713 */       this.reported = _o_.reported;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 719 */       _os_.marshal(this.win);
/* 720 */       _os_.marshal(this.lose);
/* 721 */       _os_.marshal(this.point);
/* 722 */       _os_.marshal(this.update_time);
/* 723 */       _os_.marshal(this.reported);
/* 724 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 730 */       this.win = _os_.unmarshal_int();
/* 731 */       this.lose = _os_.unmarshal_int();
/* 732 */       this.point = _os_.unmarshal_int();
/* 733 */       this.update_time = _os_.unmarshal_long();
/* 734 */       this.reported = _os_.unmarshal_boolean();
/* 735 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 741 */       int _size_ = 0;
/* 742 */       _size_ += CodedOutputStream.computeInt32Size(1, this.win);
/* 743 */       _size_ += CodedOutputStream.computeInt32Size(2, this.lose);
/* 744 */       _size_ += CodedOutputStream.computeInt32Size(3, this.point);
/* 745 */       _size_ += CodedOutputStream.computeInt64Size(4, this.update_time);
/* 746 */       _size_ += CodedOutputStream.computeBoolSize(5, this.reported);
/* 747 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 755 */         _output_.writeInt32(1, this.win);
/* 756 */         _output_.writeInt32(2, this.lose);
/* 757 */         _output_.writeInt32(3, this.point);
/* 758 */         _output_.writeInt64(4, this.update_time);
/* 759 */         _output_.writeBool(5, this.reported);
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
/* 786 */             this.win = _input_.readInt32();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 791 */             this.lose = _input_.readInt32();
/* 792 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 796 */             this.point = _input_.readInt32();
/* 797 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 801 */             this.update_time = _input_.readInt64();
/* 802 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 806 */             this.reported = _input_.readBool();
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
/*     */     public xbean.PointRaceInfo copy()
/*     */     {
/* 834 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PointRaceInfo toData()
/*     */     {
/* 840 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PointRaceInfo toBean()
/*     */     {
/* 845 */       return new PointRaceInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PointRaceInfo toDataIf()
/*     */     {
/* 851 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PointRaceInfo toBeanIf()
/*     */     {
/* 856 */       return new PointRaceInfo(this, null, null);
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
/*     */     public int getWin()
/*     */     {
/* 893 */       return this.win;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLose()
/*     */     {
/* 900 */       return this.lose;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPoint()
/*     */     {
/* 907 */       return this.point;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getUpdate_time()
/*     */     {
/* 914 */       return this.update_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getReported()
/*     */     {
/* 921 */       return this.reported;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWin(int _v_)
/*     */     {
/* 928 */       this.win = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLose(int _v_)
/*     */     {
/* 935 */       this.lose = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPoint(int _v_)
/*     */     {
/* 942 */       this.point = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUpdate_time(long _v_)
/*     */     {
/* 949 */       this.update_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReported(boolean _v_)
/*     */     {
/* 956 */       this.reported = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 962 */       if (!(_o1_ instanceof Data)) return false;
/* 963 */       Data _o_ = (Data)_o1_;
/* 964 */       if (this.win != _o_.win) return false;
/* 965 */       if (this.lose != _o_.lose) return false;
/* 966 */       if (this.point != _o_.point) return false;
/* 967 */       if (this.update_time != _o_.update_time) return false;
/* 968 */       if (this.reported != _o_.reported) return false;
/* 969 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 975 */       int _h_ = 0;
/* 976 */       _h_ += this.win;
/* 977 */       _h_ += this.lose;
/* 978 */       _h_ += this.point;
/* 979 */       _h_ = (int)(_h_ + this.update_time);
/* 980 */       _h_ += (this.reported ? 1231 : 1237);
/* 981 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 987 */       StringBuilder _sb_ = new StringBuilder();
/* 988 */       _sb_.append("(");
/* 989 */       _sb_.append(this.win);
/* 990 */       _sb_.append(",");
/* 991 */       _sb_.append(this.lose);
/* 992 */       _sb_.append(",");
/* 993 */       _sb_.append(this.point);
/* 994 */       _sb_.append(",");
/* 995 */       _sb_.append(this.update_time);
/* 996 */       _sb_.append(",");
/* 997 */       _sb_.append(this.reported);
/* 998 */       _sb_.append(")");
/* 999 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PointRaceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */