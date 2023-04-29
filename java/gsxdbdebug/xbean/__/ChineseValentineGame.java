/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class ChineseValentineGame extends XBean implements xbean.ChineseValentineGame
/*     */ {
/*     */   private long starttime;
/*     */   private ArrayList<Long> roleidlist;
/*     */   private xbean.ChineseValentineRound roundinfo;
/*     */   private int rightcount;
/*     */   private int wrongcount;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.starttime = 0L;
/*  27 */     this.roleidlist.clear();
/*  28 */     this.roundinfo._reset_unsafe_();
/*  29 */     this.rightcount = 0;
/*  30 */     this.wrongcount = 0;
/*     */   }
/*     */   
/*     */   ChineseValentineGame(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*  36 */     this.roleidlist = new ArrayList();
/*  37 */     this.roundinfo = new ChineseValentineRound(0, this, "roundinfo");
/*     */   }
/*     */   
/*     */   public ChineseValentineGame()
/*     */   {
/*  42 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ChineseValentineGame(ChineseValentineGame _o_)
/*     */   {
/*  47 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ChineseValentineGame(xbean.ChineseValentineGame _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  52 */     super(_xp_, _vn_);
/*  53 */     if ((_o1_ instanceof ChineseValentineGame)) { assign((ChineseValentineGame)_o1_);
/*  54 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  55 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  56 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ChineseValentineGame _o_) {
/*  61 */     _o_._xdb_verify_unsafe_();
/*  62 */     this.starttime = _o_.starttime;
/*  63 */     this.roleidlist = new ArrayList();
/*  64 */     this.roleidlist.addAll(_o_.roleidlist);
/*  65 */     this.roundinfo = new ChineseValentineRound(_o_.roundinfo, this, "roundinfo");
/*  66 */     this.rightcount = _o_.rightcount;
/*  67 */     this.wrongcount = _o_.wrongcount;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  72 */     this.starttime = _o_.starttime;
/*  73 */     this.roleidlist = new ArrayList();
/*  74 */     this.roleidlist.addAll(_o_.roleidlist);
/*  75 */     this.roundinfo = new ChineseValentineRound(_o_.roundinfo, this, "roundinfo");
/*  76 */     this.rightcount = _o_.rightcount;
/*  77 */     this.wrongcount = _o_.wrongcount;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     _os_.marshal(this.starttime);
/*  85 */     _os_.compact_uint32(this.roleidlist.size());
/*  86 */     for (Long _v_ : this.roleidlist)
/*     */     {
/*  88 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  90 */     this.roundinfo.marshal(_os_);
/*  91 */     _os_.marshal(this.rightcount);
/*  92 */     _os_.marshal(this.wrongcount);
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     this.starttime = _os_.unmarshal_long();
/* 101 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 103 */       long _v_ = 0L;
/* 104 */       _v_ = _os_.unmarshal_long();
/* 105 */       this.roleidlist.add(Long.valueOf(_v_));
/*     */     }
/* 107 */     this.roundinfo.unmarshal(_os_);
/* 108 */     this.rightcount = _os_.unmarshal_int();
/* 109 */     this.wrongcount = _os_.unmarshal_int();
/* 110 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/* 117 */     int _size_ = 0;
/* 118 */     _size_ += CodedOutputStream.computeInt64Size(1, this.starttime);
/* 119 */     for (Long _v_ : this.roleidlist)
/*     */     {
/* 121 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */     }
/* 123 */     _size_ += CodedOutputStream.computeMessageSize(3, this.roundinfo);
/* 124 */     _size_ += CodedOutputStream.computeInt32Size(4, this.rightcount);
/* 125 */     _size_ += CodedOutputStream.computeInt32Size(5, this.wrongcount);
/* 126 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 132 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 135 */       _output_.writeInt64(1, this.starttime);
/* 136 */       for (Long _v_ : this.roleidlist)
/*     */       {
/* 138 */         _output_.writeInt64(2, _v_.longValue());
/*     */       }
/* 140 */       _output_.writeMessage(3, this.roundinfo);
/* 141 */       _output_.writeInt32(4, this.rightcount);
/* 142 */       _output_.writeInt32(5, this.wrongcount);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 146 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 148 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 154 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 157 */       boolean done = false;
/* 158 */       while (!done)
/*     */       {
/* 160 */         int tag = _input_.readTag();
/* 161 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 165 */           done = true;
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 170 */           this.starttime = _input_.readInt64();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 175 */           long _v_ = 0L;
/* 176 */           _v_ = _input_.readInt64();
/* 177 */           this.roleidlist.add(Long.valueOf(_v_));
/* 178 */           break;
/*     */         
/*     */ 
/*     */         case 26: 
/* 182 */           _input_.readMessage(this.roundinfo);
/* 183 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 187 */           this.rightcount = _input_.readInt32();
/* 188 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 192 */           this.wrongcount = _input_.readInt32();
/* 193 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 197 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 199 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 208 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 212 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 214 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChineseValentineGame copy()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new ChineseValentineGame(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChineseValentineGame toData()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChineseValentineGame toBean()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new ChineseValentineGame(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChineseValentineGame toDataIf()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChineseValentineGame toBeanIf()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStarttime()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.starttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getRoleidlist()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return xdb.Logs.logList(new LogKey(this, "roleidlist"), this.roleidlist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getRoleidlistAsData()
/*     */   {
/* 276 */     _xdb_verify_unsafe_();
/*     */     
/* 278 */     ChineseValentineGame _o_ = this;
/* 279 */     List<Long> roleidlist = new ArrayList();
/* 280 */     roleidlist.addAll(_o_.roleidlist);
/* 281 */     return roleidlist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.ChineseValentineRound getRoundinfo()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     return this.roundinfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRightcount()
/*     */   {
/* 296 */     _xdb_verify_unsafe_();
/* 297 */     return this.rightcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getWrongcount()
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     return this.wrongcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStarttime(long _v_)
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     xdb.Logs.logIf(new LogKey(this, "starttime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 317 */         new xdb.logs.LogLong(this, ChineseValentineGame.this.starttime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 321 */             ChineseValentineGame.this.starttime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 325 */     });
/* 326 */     this.starttime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRightcount(int _v_)
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     xdb.Logs.logIf(new LogKey(this, "rightcount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 338 */         new xdb.logs.LogInt(this, ChineseValentineGame.this.rightcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 342 */             ChineseValentineGame.this.rightcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 346 */     });
/* 347 */     this.rightcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWrongcount(int _v_)
/*     */   {
/* 354 */     _xdb_verify_unsafe_();
/* 355 */     xdb.Logs.logIf(new LogKey(this, "wrongcount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 359 */         new xdb.logs.LogInt(this, ChineseValentineGame.this.wrongcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 363 */             ChineseValentineGame.this.wrongcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 367 */     });
/* 368 */     this.wrongcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 374 */     _xdb_verify_unsafe_();
/* 375 */     ChineseValentineGame _o_ = null;
/* 376 */     if ((_o1_ instanceof ChineseValentineGame)) { _o_ = (ChineseValentineGame)_o1_;
/* 377 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 378 */       return false;
/* 379 */     if (this.starttime != _o_.starttime) return false;
/* 380 */     if (!this.roleidlist.equals(_o_.roleidlist)) return false;
/* 381 */     if (!this.roundinfo.equals(_o_.roundinfo)) return false;
/* 382 */     if (this.rightcount != _o_.rightcount) return false;
/* 383 */     if (this.wrongcount != _o_.wrongcount) return false;
/* 384 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 390 */     _xdb_verify_unsafe_();
/* 391 */     int _h_ = 0;
/* 392 */     _h_ = (int)(_h_ + this.starttime);
/* 393 */     _h_ += this.roleidlist.hashCode();
/* 394 */     _h_ += this.roundinfo.hashCode();
/* 395 */     _h_ += this.rightcount;
/* 396 */     _h_ += this.wrongcount;
/* 397 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 403 */     _xdb_verify_unsafe_();
/* 404 */     StringBuilder _sb_ = new StringBuilder();
/* 405 */     _sb_.append("(");
/* 406 */     _sb_.append(this.starttime);
/* 407 */     _sb_.append(",");
/* 408 */     _sb_.append(this.roleidlist);
/* 409 */     _sb_.append(",");
/* 410 */     _sb_.append(this.roundinfo);
/* 411 */     _sb_.append(",");
/* 412 */     _sb_.append(this.rightcount);
/* 413 */     _sb_.append(",");
/* 414 */     _sb_.append(this.wrongcount);
/* 415 */     _sb_.append(")");
/* 416 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 422 */     ListenableBean lb = new ListenableBean();
/* 423 */     lb.add(new ListenableChanged().setVarName("starttime"));
/* 424 */     lb.add(new ListenableChanged().setVarName("roleidlist"));
/* 425 */     lb.add(new ListenableChanged().setVarName("roundinfo"));
/* 426 */     lb.add(new ListenableChanged().setVarName("rightcount"));
/* 427 */     lb.add(new ListenableChanged().setVarName("wrongcount"));
/* 428 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ChineseValentineGame {
/*     */     private Const() {}
/*     */     
/*     */     ChineseValentineGame nThis() {
/* 435 */       return ChineseValentineGame.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 441 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChineseValentineGame copy()
/*     */     {
/* 447 */       return ChineseValentineGame.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChineseValentineGame toData()
/*     */     {
/* 453 */       return ChineseValentineGame.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ChineseValentineGame toBean()
/*     */     {
/* 458 */       return ChineseValentineGame.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChineseValentineGame toDataIf()
/*     */     {
/* 464 */       return ChineseValentineGame.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ChineseValentineGame toBeanIf()
/*     */     {
/* 469 */       return ChineseValentineGame.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStarttime()
/*     */     {
/* 476 */       ChineseValentineGame.this._xdb_verify_unsafe_();
/* 477 */       return ChineseValentineGame.this.starttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRoleidlist()
/*     */     {
/* 484 */       ChineseValentineGame.this._xdb_verify_unsafe_();
/* 485 */       return xdb.Consts.constList(ChineseValentineGame.this.roleidlist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getRoleidlistAsData()
/*     */     {
/* 491 */       ChineseValentineGame.this._xdb_verify_unsafe_();
/*     */       
/* 493 */       ChineseValentineGame _o_ = ChineseValentineGame.this;
/* 494 */       List<Long> roleidlist = new ArrayList();
/* 495 */       roleidlist.addAll(_o_.roleidlist);
/* 496 */       return roleidlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.ChineseValentineRound getRoundinfo()
/*     */     {
/* 503 */       ChineseValentineGame.this._xdb_verify_unsafe_();
/* 504 */       return (xbean.ChineseValentineRound)xdb.Consts.toConst(ChineseValentineGame.this.roundinfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRightcount()
/*     */     {
/* 511 */       ChineseValentineGame.this._xdb_verify_unsafe_();
/* 512 */       return ChineseValentineGame.this.rightcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getWrongcount()
/*     */     {
/* 519 */       ChineseValentineGame.this._xdb_verify_unsafe_();
/* 520 */       return ChineseValentineGame.this.wrongcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttime(long _v_)
/*     */     {
/* 527 */       ChineseValentineGame.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRightcount(int _v_)
/*     */     {
/* 535 */       ChineseValentineGame.this._xdb_verify_unsafe_();
/* 536 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWrongcount(int _v_)
/*     */     {
/* 543 */       ChineseValentineGame.this._xdb_verify_unsafe_();
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 550 */       ChineseValentineGame.this._xdb_verify_unsafe_();
/* 551 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 557 */       ChineseValentineGame.this._xdb_verify_unsafe_();
/* 558 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 564 */       return ChineseValentineGame.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 570 */       return ChineseValentineGame.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 576 */       ChineseValentineGame.this._xdb_verify_unsafe_();
/* 577 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 583 */       return ChineseValentineGame.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 589 */       return ChineseValentineGame.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 595 */       ChineseValentineGame.this._xdb_verify_unsafe_();
/* 596 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 602 */       return ChineseValentineGame.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 608 */       return ChineseValentineGame.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 614 */       return ChineseValentineGame.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 620 */       return ChineseValentineGame.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 626 */       return ChineseValentineGame.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 632 */       return ChineseValentineGame.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 638 */       return ChineseValentineGame.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ChineseValentineGame
/*     */   {
/*     */     private long starttime;
/*     */     
/*     */     private ArrayList<Long> roleidlist;
/*     */     
/*     */     private xbean.ChineseValentineRound roundinfo;
/*     */     
/*     */     private int rightcount;
/*     */     
/*     */     private int wrongcount;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 658 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 663 */       this.roleidlist = new ArrayList();
/* 664 */       this.roundinfo = new ChineseValentineRound.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.ChineseValentineGame _o1_)
/*     */     {
/* 669 */       if ((_o1_ instanceof ChineseValentineGame)) { assign((ChineseValentineGame)_o1_);
/* 670 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 671 */       } else if ((_o1_ instanceof ChineseValentineGame.Const)) assign(((ChineseValentineGame.Const)_o1_).nThis()); else {
/* 672 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ChineseValentineGame _o_) {
/* 677 */       this.starttime = _o_.starttime;
/* 678 */       this.roleidlist = new ArrayList();
/* 679 */       this.roleidlist.addAll(_o_.roleidlist);
/* 680 */       this.roundinfo = new ChineseValentineRound.Data(_o_.roundinfo);
/* 681 */       this.rightcount = _o_.rightcount;
/* 682 */       this.wrongcount = _o_.wrongcount;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 687 */       this.starttime = _o_.starttime;
/* 688 */       this.roleidlist = new ArrayList();
/* 689 */       this.roleidlist.addAll(_o_.roleidlist);
/* 690 */       this.roundinfo = new ChineseValentineRound.Data(_o_.roundinfo);
/* 691 */       this.rightcount = _o_.rightcount;
/* 692 */       this.wrongcount = _o_.wrongcount;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 698 */       _os_.marshal(this.starttime);
/* 699 */       _os_.compact_uint32(this.roleidlist.size());
/* 700 */       for (Long _v_ : this.roleidlist)
/*     */       {
/* 702 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 704 */       this.roundinfo.marshal(_os_);
/* 705 */       _os_.marshal(this.rightcount);
/* 706 */       _os_.marshal(this.wrongcount);
/* 707 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 713 */       this.starttime = _os_.unmarshal_long();
/* 714 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 716 */         long _v_ = 0L;
/* 717 */         _v_ = _os_.unmarshal_long();
/* 718 */         this.roleidlist.add(Long.valueOf(_v_));
/*     */       }
/* 720 */       this.roundinfo.unmarshal(_os_);
/* 721 */       this.rightcount = _os_.unmarshal_int();
/* 722 */       this.wrongcount = _os_.unmarshal_int();
/* 723 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 729 */       int _size_ = 0;
/* 730 */       _size_ += CodedOutputStream.computeInt64Size(1, this.starttime);
/* 731 */       for (Long _v_ : this.roleidlist)
/*     */       {
/* 733 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */       }
/* 735 */       _size_ += CodedOutputStream.computeMessageSize(3, this.roundinfo);
/* 736 */       _size_ += CodedOutputStream.computeInt32Size(4, this.rightcount);
/* 737 */       _size_ += CodedOutputStream.computeInt32Size(5, this.wrongcount);
/* 738 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 746 */         _output_.writeInt64(1, this.starttime);
/* 747 */         for (Long _v_ : this.roleidlist)
/*     */         {
/* 749 */           _output_.writeInt64(2, _v_.longValue());
/*     */         }
/* 751 */         _output_.writeMessage(3, this.roundinfo);
/* 752 */         _output_.writeInt32(4, this.rightcount);
/* 753 */         _output_.writeInt32(5, this.wrongcount);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 757 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 759 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 767 */         boolean done = false;
/* 768 */         while (!done)
/*     */         {
/* 770 */           int tag = _input_.readTag();
/* 771 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 775 */             done = true;
/* 776 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 780 */             this.starttime = _input_.readInt64();
/* 781 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 785 */             long _v_ = 0L;
/* 786 */             _v_ = _input_.readInt64();
/* 787 */             this.roleidlist.add(Long.valueOf(_v_));
/* 788 */             break;
/*     */           
/*     */ 
/*     */           case 26: 
/* 792 */             _input_.readMessage(this.roundinfo);
/* 793 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 797 */             this.rightcount = _input_.readInt32();
/* 798 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 802 */             this.wrongcount = _input_.readInt32();
/* 803 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 807 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 809 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 818 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 822 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 824 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChineseValentineGame copy()
/*     */     {
/* 830 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChineseValentineGame toData()
/*     */     {
/* 836 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ChineseValentineGame toBean()
/*     */     {
/* 841 */       return new ChineseValentineGame(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChineseValentineGame toDataIf()
/*     */     {
/* 847 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ChineseValentineGame toBeanIf()
/*     */     {
/* 852 */       return new ChineseValentineGame(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 858 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 862 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 866 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 870 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 874 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 878 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 882 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStarttime()
/*     */     {
/* 889 */       return this.starttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRoleidlist()
/*     */     {
/* 896 */       return this.roleidlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRoleidlistAsData()
/*     */     {
/* 903 */       return this.roleidlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.ChineseValentineRound getRoundinfo()
/*     */     {
/* 910 */       return this.roundinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRightcount()
/*     */     {
/* 917 */       return this.rightcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getWrongcount()
/*     */     {
/* 924 */       return this.wrongcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttime(long _v_)
/*     */     {
/* 931 */       this.starttime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRightcount(int _v_)
/*     */     {
/* 938 */       this.rightcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWrongcount(int _v_)
/*     */     {
/* 945 */       this.wrongcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 951 */       if (!(_o1_ instanceof Data)) return false;
/* 952 */       Data _o_ = (Data)_o1_;
/* 953 */       if (this.starttime != _o_.starttime) return false;
/* 954 */       if (!this.roleidlist.equals(_o_.roleidlist)) return false;
/* 955 */       if (!this.roundinfo.equals(_o_.roundinfo)) return false;
/* 956 */       if (this.rightcount != _o_.rightcount) return false;
/* 957 */       if (this.wrongcount != _o_.wrongcount) return false;
/* 958 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 964 */       int _h_ = 0;
/* 965 */       _h_ = (int)(_h_ + this.starttime);
/* 966 */       _h_ += this.roleidlist.hashCode();
/* 967 */       _h_ += this.roundinfo.hashCode();
/* 968 */       _h_ += this.rightcount;
/* 969 */       _h_ += this.wrongcount;
/* 970 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 976 */       StringBuilder _sb_ = new StringBuilder();
/* 977 */       _sb_.append("(");
/* 978 */       _sb_.append(this.starttime);
/* 979 */       _sb_.append(",");
/* 980 */       _sb_.append(this.roleidlist);
/* 981 */       _sb_.append(",");
/* 982 */       _sb_.append(this.roundinfo);
/* 983 */       _sb_.append(",");
/* 984 */       _sb_.append(this.rightcount);
/* 985 */       _sb_.append(",");
/* 986 */       _sb_.append(this.wrongcount);
/* 987 */       _sb_.append(")");
/* 988 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChineseValentineGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */