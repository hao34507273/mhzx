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
/*     */ public final class BigBossActivity extends XBean implements xbean.BigBossActivity
/*     */ {
/*     */   private long starttime;
/*     */   private long endtime;
/*     */   private int monsterid;
/*     */   private int reserved;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.starttime = 0L;
/*  25 */     this.endtime = 0L;
/*  26 */     this.monsterid = 0;
/*  27 */     this.reserved = 0;
/*     */   }
/*     */   
/*     */   BigBossActivity(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.starttime = 0L;
/*  34 */     this.endtime = 0L;
/*  35 */     this.monsterid = 0;
/*  36 */     this.reserved = 0;
/*     */   }
/*     */   
/*     */   public BigBossActivity()
/*     */   {
/*  41 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public BigBossActivity(BigBossActivity _o_)
/*     */   {
/*  46 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   BigBossActivity(xbean.BigBossActivity _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  51 */     super(_xp_, _vn_);
/*  52 */     if ((_o1_ instanceof BigBossActivity)) { assign((BigBossActivity)_o1_);
/*  53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  55 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(BigBossActivity _o_) {
/*  60 */     _o_._xdb_verify_unsafe_();
/*  61 */     this.starttime = _o_.starttime;
/*  62 */     this.endtime = _o_.endtime;
/*  63 */     this.monsterid = _o_.monsterid;
/*  64 */     this.reserved = _o_.reserved;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.starttime = _o_.starttime;
/*  70 */     this.endtime = _o_.endtime;
/*  71 */     this.monsterid = _o_.monsterid;
/*  72 */     this.reserved = _o_.reserved;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  78 */     _xdb_verify_unsafe_();
/*  79 */     _os_.marshal(this.starttime);
/*  80 */     _os_.marshal(this.endtime);
/*  81 */     _os_.marshal(this.monsterid);
/*  82 */     _os_.marshal(this.reserved);
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     this.starttime = _os_.unmarshal_long();
/*  91 */     this.endtime = _os_.unmarshal_long();
/*  92 */     this.monsterid = _os_.unmarshal_int();
/*  93 */     this.reserved = _os_.unmarshal_int();
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/* 101 */     int _size_ = 0;
/* 102 */     _size_ += CodedOutputStream.computeInt64Size(1, this.starttime);
/* 103 */     _size_ += CodedOutputStream.computeInt64Size(2, this.endtime);
/* 104 */     _size_ += CodedOutputStream.computeInt32Size(3, this.monsterid);
/* 105 */     _size_ += CodedOutputStream.computeInt32Size(4, this.reserved);
/* 106 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 112 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 115 */       _output_.writeInt64(1, this.starttime);
/* 116 */       _output_.writeInt64(2, this.endtime);
/* 117 */       _output_.writeInt32(3, this.monsterid);
/* 118 */       _output_.writeInt32(4, this.reserved);
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
/* 146 */           this.starttime = _input_.readInt64();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 151 */           this.endtime = _input_.readInt64();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 156 */           this.monsterid = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 161 */           this.reserved = _input_.readInt32();
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
/*     */   public xbean.BigBossActivity copy()
/*     */   {
/* 189 */     _xdb_verify_unsafe_();
/* 190 */     return new BigBossActivity(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BigBossActivity toData()
/*     */   {
/* 196 */     _xdb_verify_unsafe_();
/* 197 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.BigBossActivity toBean()
/*     */   {
/* 202 */     _xdb_verify_unsafe_();
/* 203 */     return new BigBossActivity(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BigBossActivity toDataIf()
/*     */   {
/* 209 */     _xdb_verify_unsafe_();
/* 210 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.BigBossActivity toBeanIf()
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
/*     */   public long getStarttime()
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     return this.starttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getEndtime()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this.endtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMonsterid()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return this.monsterid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getReserved()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return this.reserved;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStarttime(long _v_)
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/* 263 */     xdb.Logs.logIf(new LogKey(this, "starttime")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 267 */         new xdb.logs.LogLong(this, BigBossActivity.this.starttime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 271 */             BigBossActivity.this.starttime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 275 */     });
/* 276 */     this.starttime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEndtime(long _v_)
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     xdb.Logs.logIf(new LogKey(this, "endtime")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 288 */         new xdb.logs.LogLong(this, BigBossActivity.this.endtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 292 */             BigBossActivity.this.endtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 296 */     });
/* 297 */     this.endtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMonsterid(int _v_)
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     xdb.Logs.logIf(new LogKey(this, "monsterid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 309 */         new xdb.logs.LogInt(this, BigBossActivity.this.monsterid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 313 */             BigBossActivity.this.monsterid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 317 */     });
/* 318 */     this.monsterid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReserved(int _v_)
/*     */   {
/* 325 */     _xdb_verify_unsafe_();
/* 326 */     xdb.Logs.logIf(new LogKey(this, "reserved")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 330 */         new xdb.logs.LogInt(this, BigBossActivity.this.reserved)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 334 */             BigBossActivity.this.reserved = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 338 */     });
/* 339 */     this.reserved = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     BigBossActivity _o_ = null;
/* 347 */     if ((_o1_ instanceof BigBossActivity)) { _o_ = (BigBossActivity)_o1_;
/* 348 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 349 */       return false;
/* 350 */     if (this.starttime != _o_.starttime) return false;
/* 351 */     if (this.endtime != _o_.endtime) return false;
/* 352 */     if (this.monsterid != _o_.monsterid) return false;
/* 353 */     if (this.reserved != _o_.reserved) return false;
/* 354 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 360 */     _xdb_verify_unsafe_();
/* 361 */     int _h_ = 0;
/* 362 */     _h_ = (int)(_h_ + this.starttime);
/* 363 */     _h_ = (int)(_h_ + this.endtime);
/* 364 */     _h_ += this.monsterid;
/* 365 */     _h_ += this.reserved;
/* 366 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 372 */     _xdb_verify_unsafe_();
/* 373 */     StringBuilder _sb_ = new StringBuilder();
/* 374 */     _sb_.append("(");
/* 375 */     _sb_.append(this.starttime);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.endtime);
/* 378 */     _sb_.append(",");
/* 379 */     _sb_.append(this.monsterid);
/* 380 */     _sb_.append(",");
/* 381 */     _sb_.append(this.reserved);
/* 382 */     _sb_.append(")");
/* 383 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 389 */     ListenableBean lb = new ListenableBean();
/* 390 */     lb.add(new ListenableChanged().setVarName("starttime"));
/* 391 */     lb.add(new ListenableChanged().setVarName("endtime"));
/* 392 */     lb.add(new ListenableChanged().setVarName("monsterid"));
/* 393 */     lb.add(new ListenableChanged().setVarName("reserved"));
/* 394 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.BigBossActivity {
/*     */     private Const() {}
/*     */     
/*     */     BigBossActivity nThis() {
/* 401 */       return BigBossActivity.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 407 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BigBossActivity copy()
/*     */     {
/* 413 */       return BigBossActivity.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BigBossActivity toData()
/*     */     {
/* 419 */       return BigBossActivity.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.BigBossActivity toBean()
/*     */     {
/* 424 */       return BigBossActivity.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BigBossActivity toDataIf()
/*     */     {
/* 430 */       return BigBossActivity.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.BigBossActivity toBeanIf()
/*     */     {
/* 435 */       return BigBossActivity.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStarttime()
/*     */     {
/* 442 */       BigBossActivity.this._xdb_verify_unsafe_();
/* 443 */       return BigBossActivity.this.starttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getEndtime()
/*     */     {
/* 450 */       BigBossActivity.this._xdb_verify_unsafe_();
/* 451 */       return BigBossActivity.this.endtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMonsterid()
/*     */     {
/* 458 */       BigBossActivity.this._xdb_verify_unsafe_();
/* 459 */       return BigBossActivity.this.monsterid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getReserved()
/*     */     {
/* 466 */       BigBossActivity.this._xdb_verify_unsafe_();
/* 467 */       return BigBossActivity.this.reserved;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttime(long _v_)
/*     */     {
/* 474 */       BigBossActivity.this._xdb_verify_unsafe_();
/* 475 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEndtime(long _v_)
/*     */     {
/* 482 */       BigBossActivity.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMonsterid(int _v_)
/*     */     {
/* 490 */       BigBossActivity.this._xdb_verify_unsafe_();
/* 491 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReserved(int _v_)
/*     */     {
/* 498 */       BigBossActivity.this._xdb_verify_unsafe_();
/* 499 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 505 */       BigBossActivity.this._xdb_verify_unsafe_();
/* 506 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 512 */       BigBossActivity.this._xdb_verify_unsafe_();
/* 513 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 519 */       return BigBossActivity.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 525 */       return BigBossActivity.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 531 */       BigBossActivity.this._xdb_verify_unsafe_();
/* 532 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 538 */       return BigBossActivity.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 544 */       return BigBossActivity.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 550 */       BigBossActivity.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 557 */       return BigBossActivity.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 563 */       return BigBossActivity.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 569 */       return BigBossActivity.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 575 */       return BigBossActivity.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 581 */       return BigBossActivity.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 587 */       return BigBossActivity.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 593 */       return BigBossActivity.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.BigBossActivity
/*     */   {
/*     */     private long starttime;
/*     */     
/*     */     private long endtime;
/*     */     
/*     */     private int monsterid;
/*     */     
/*     */     private int reserved;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 611 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 616 */       this.starttime = 0L;
/* 617 */       this.endtime = 0L;
/* 618 */       this.monsterid = 0;
/* 619 */       this.reserved = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.BigBossActivity _o1_)
/*     */     {
/* 624 */       if ((_o1_ instanceof BigBossActivity)) { assign((BigBossActivity)_o1_);
/* 625 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 626 */       } else if ((_o1_ instanceof BigBossActivity.Const)) assign(((BigBossActivity.Const)_o1_).nThis()); else {
/* 627 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(BigBossActivity _o_) {
/* 632 */       this.starttime = _o_.starttime;
/* 633 */       this.endtime = _o_.endtime;
/* 634 */       this.monsterid = _o_.monsterid;
/* 635 */       this.reserved = _o_.reserved;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 640 */       this.starttime = _o_.starttime;
/* 641 */       this.endtime = _o_.endtime;
/* 642 */       this.monsterid = _o_.monsterid;
/* 643 */       this.reserved = _o_.reserved;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 649 */       _os_.marshal(this.starttime);
/* 650 */       _os_.marshal(this.endtime);
/* 651 */       _os_.marshal(this.monsterid);
/* 652 */       _os_.marshal(this.reserved);
/* 653 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 659 */       this.starttime = _os_.unmarshal_long();
/* 660 */       this.endtime = _os_.unmarshal_long();
/* 661 */       this.monsterid = _os_.unmarshal_int();
/* 662 */       this.reserved = _os_.unmarshal_int();
/* 663 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 669 */       int _size_ = 0;
/* 670 */       _size_ += CodedOutputStream.computeInt64Size(1, this.starttime);
/* 671 */       _size_ += CodedOutputStream.computeInt64Size(2, this.endtime);
/* 672 */       _size_ += CodedOutputStream.computeInt32Size(3, this.monsterid);
/* 673 */       _size_ += CodedOutputStream.computeInt32Size(4, this.reserved);
/* 674 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 682 */         _output_.writeInt64(1, this.starttime);
/* 683 */         _output_.writeInt64(2, this.endtime);
/* 684 */         _output_.writeInt32(3, this.monsterid);
/* 685 */         _output_.writeInt32(4, this.reserved);
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
/* 712 */             this.starttime = _input_.readInt64();
/* 713 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 717 */             this.endtime = _input_.readInt64();
/* 718 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 722 */             this.monsterid = _input_.readInt32();
/* 723 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 727 */             this.reserved = _input_.readInt32();
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
/*     */     public xbean.BigBossActivity copy()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BigBossActivity toData()
/*     */     {
/* 761 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.BigBossActivity toBean()
/*     */     {
/* 766 */       return new BigBossActivity(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BigBossActivity toDataIf()
/*     */     {
/* 772 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.BigBossActivity toBeanIf()
/*     */     {
/* 777 */       return new BigBossActivity(this, null, null);
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
/*     */     public long getStarttime()
/*     */     {
/* 814 */       return this.starttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getEndtime()
/*     */     {
/* 821 */       return this.endtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMonsterid()
/*     */     {
/* 828 */       return this.monsterid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getReserved()
/*     */     {
/* 835 */       return this.reserved;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttime(long _v_)
/*     */     {
/* 842 */       this.starttime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEndtime(long _v_)
/*     */     {
/* 849 */       this.endtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMonsterid(int _v_)
/*     */     {
/* 856 */       this.monsterid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReserved(int _v_)
/*     */     {
/* 863 */       this.reserved = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 869 */       if (!(_o1_ instanceof Data)) return false;
/* 870 */       Data _o_ = (Data)_o1_;
/* 871 */       if (this.starttime != _o_.starttime) return false;
/* 872 */       if (this.endtime != _o_.endtime) return false;
/* 873 */       if (this.monsterid != _o_.monsterid) return false;
/* 874 */       if (this.reserved != _o_.reserved) return false;
/* 875 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 881 */       int _h_ = 0;
/* 882 */       _h_ = (int)(_h_ + this.starttime);
/* 883 */       _h_ = (int)(_h_ + this.endtime);
/* 884 */       _h_ += this.monsterid;
/* 885 */       _h_ += this.reserved;
/* 886 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 892 */       StringBuilder _sb_ = new StringBuilder();
/* 893 */       _sb_.append("(");
/* 894 */       _sb_.append(this.starttime);
/* 895 */       _sb_.append(",");
/* 896 */       _sb_.append(this.endtime);
/* 897 */       _sb_.append(",");
/* 898 */       _sb_.append(this.monsterid);
/* 899 */       _sb_.append(",");
/* 900 */       _sb_.append(this.reserved);
/* 901 */       _sb_.append(")");
/* 902 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BigBossActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */