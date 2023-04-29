/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class RoleWordQuestionInfo extends XBean implements xbean.RoleWordQuestionInfo
/*     */ {
/*     */   private ArrayList<Integer> questionidlist;
/*     */   private int rightnum;
/*     */   private int curidx;
/*     */   private long sessionid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.questionidlist.clear();
/*  25 */     this.rightnum = 0;
/*  26 */     this.curidx = 0;
/*  27 */     this.sessionid = 0L;
/*     */   }
/*     */   
/*     */   RoleWordQuestionInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.questionidlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public RoleWordQuestionInfo()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleWordQuestionInfo(RoleWordQuestionInfo _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleWordQuestionInfo(xbean.RoleWordQuestionInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof RoleWordQuestionInfo)) { assign((RoleWordQuestionInfo)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleWordQuestionInfo _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.questionidlist = new ArrayList();
/*  59 */     this.questionidlist.addAll(_o_.questionidlist);
/*  60 */     this.rightnum = _o_.rightnum;
/*  61 */     this.curidx = _o_.curidx;
/*  62 */     this.sessionid = _o_.sessionid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  67 */     this.questionidlist = new ArrayList();
/*  68 */     this.questionidlist.addAll(_o_.questionidlist);
/*  69 */     this.rightnum = _o_.rightnum;
/*  70 */     this.curidx = _o_.curidx;
/*  71 */     this.sessionid = _o_.sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*  78 */     _os_.compact_uint32(this.questionidlist.size());
/*  79 */     for (Integer _v_ : this.questionidlist)
/*     */     {
/*  81 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  83 */     _os_.marshal(this.rightnum);
/*  84 */     _os_.marshal(this.curidx);
/*  85 */     _os_.marshal(this.sessionid);
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  95 */       int _v_ = 0;
/*  96 */       _v_ = _os_.unmarshal_int();
/*  97 */       this.questionidlist.add(Integer.valueOf(_v_));
/*     */     }
/*  99 */     this.rightnum = _os_.unmarshal_int();
/* 100 */     this.curidx = _os_.unmarshal_int();
/* 101 */     this.sessionid = _os_.unmarshal_long();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/* 109 */     int _size_ = 0;
/* 110 */     for (Integer _v_ : this.questionidlist)
/*     */     {
/* 112 */       _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */     }
/* 114 */     _size_ += CodedOutputStream.computeInt32Size(2, this.rightnum);
/* 115 */     _size_ += CodedOutputStream.computeInt32Size(3, this.curidx);
/* 116 */     _size_ += CodedOutputStream.computeInt64Size(4, this.sessionid);
/* 117 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 123 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 126 */       for (Integer _v_ : this.questionidlist)
/*     */       {
/* 128 */         _output_.writeInt32(1, _v_.intValue());
/*     */       }
/* 130 */       _output_.writeInt32(2, this.rightnum);
/* 131 */       _output_.writeInt32(3, this.curidx);
/* 132 */       _output_.writeInt64(4, this.sessionid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 136 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 138 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 144 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 147 */       boolean done = false;
/* 148 */       while (!done)
/*     */       {
/* 150 */         int tag = _input_.readTag();
/* 151 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 155 */           done = true;
/* 156 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 160 */           int _v_ = 0;
/* 161 */           _v_ = _input_.readInt32();
/* 162 */           this.questionidlist.add(Integer.valueOf(_v_));
/* 163 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 167 */           this.rightnum = _input_.readInt32();
/* 168 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 172 */           this.curidx = _input_.readInt32();
/* 173 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 177 */           this.sessionid = _input_.readInt64();
/* 178 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 182 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 184 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 193 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 197 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 199 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleWordQuestionInfo copy()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new RoleWordQuestionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleWordQuestionInfo toData()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleWordQuestionInfo toBean()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new RoleWordQuestionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleWordQuestionInfo toDataIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleWordQuestionInfo toBeanIf()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getQuestionidlist()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return xdb.Logs.logList(new LogKey(this, "questionidlist"), this.questionidlist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getQuestionidlistAsData()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/*     */     
/* 255 */     RoleWordQuestionInfo _o_ = this;
/* 256 */     List<Integer> questionidlist = new ArrayList();
/* 257 */     questionidlist.addAll(_o_.questionidlist);
/* 258 */     return questionidlist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRightnum()
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     return this.rightnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCuridx()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return this.curidx;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSessionid()
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     return this.sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRightnum(int _v_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     xdb.Logs.logIf(new LogKey(this, "rightnum")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 294 */         new xdb.logs.LogInt(this, RoleWordQuestionInfo.this.rightnum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 298 */             RoleWordQuestionInfo.this.rightnum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 302 */     });
/* 303 */     this.rightnum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCuridx(int _v_)
/*     */   {
/* 310 */     _xdb_verify_unsafe_();
/* 311 */     xdb.Logs.logIf(new LogKey(this, "curidx")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 315 */         new xdb.logs.LogInt(this, RoleWordQuestionInfo.this.curidx)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 319 */             RoleWordQuestionInfo.this.curidx = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 323 */     });
/* 324 */     this.curidx = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSessionid(long _v_)
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/* 332 */     xdb.Logs.logIf(new LogKey(this, "sessionid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 336 */         new xdb.logs.LogLong(this, RoleWordQuestionInfo.this.sessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 340 */             RoleWordQuestionInfo.this.sessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 344 */     });
/* 345 */     this.sessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 351 */     _xdb_verify_unsafe_();
/* 352 */     RoleWordQuestionInfo _o_ = null;
/* 353 */     if ((_o1_ instanceof RoleWordQuestionInfo)) { _o_ = (RoleWordQuestionInfo)_o1_;
/* 354 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 355 */       return false;
/* 356 */     if (!this.questionidlist.equals(_o_.questionidlist)) return false;
/* 357 */     if (this.rightnum != _o_.rightnum) return false;
/* 358 */     if (this.curidx != _o_.curidx) return false;
/* 359 */     if (this.sessionid != _o_.sessionid) return false;
/* 360 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 366 */     _xdb_verify_unsafe_();
/* 367 */     int _h_ = 0;
/* 368 */     _h_ += this.questionidlist.hashCode();
/* 369 */     _h_ += this.rightnum;
/* 370 */     _h_ += this.curidx;
/* 371 */     _h_ = (int)(_h_ + this.sessionid);
/* 372 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 378 */     _xdb_verify_unsafe_();
/* 379 */     StringBuilder _sb_ = new StringBuilder();
/* 380 */     _sb_.append("(");
/* 381 */     _sb_.append(this.questionidlist);
/* 382 */     _sb_.append(",");
/* 383 */     _sb_.append(this.rightnum);
/* 384 */     _sb_.append(",");
/* 385 */     _sb_.append(this.curidx);
/* 386 */     _sb_.append(",");
/* 387 */     _sb_.append(this.sessionid);
/* 388 */     _sb_.append(")");
/* 389 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 395 */     ListenableBean lb = new ListenableBean();
/* 396 */     lb.add(new ListenableChanged().setVarName("questionidlist"));
/* 397 */     lb.add(new ListenableChanged().setVarName("rightnum"));
/* 398 */     lb.add(new ListenableChanged().setVarName("curidx"));
/* 399 */     lb.add(new ListenableChanged().setVarName("sessionid"));
/* 400 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleWordQuestionInfo {
/*     */     private Const() {}
/*     */     
/*     */     RoleWordQuestionInfo nThis() {
/* 407 */       return RoleWordQuestionInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleWordQuestionInfo copy()
/*     */     {
/* 419 */       return RoleWordQuestionInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleWordQuestionInfo toData()
/*     */     {
/* 425 */       return RoleWordQuestionInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleWordQuestionInfo toBean()
/*     */     {
/* 430 */       return RoleWordQuestionInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleWordQuestionInfo toDataIf()
/*     */     {
/* 436 */       return RoleWordQuestionInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleWordQuestionInfo toBeanIf()
/*     */     {
/* 441 */       return RoleWordQuestionInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getQuestionidlist()
/*     */     {
/* 448 */       RoleWordQuestionInfo.this._xdb_verify_unsafe_();
/* 449 */       return xdb.Consts.constList(RoleWordQuestionInfo.this.questionidlist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getQuestionidlistAsData()
/*     */     {
/* 455 */       RoleWordQuestionInfo.this._xdb_verify_unsafe_();
/*     */       
/* 457 */       RoleWordQuestionInfo _o_ = RoleWordQuestionInfo.this;
/* 458 */       List<Integer> questionidlist = new ArrayList();
/* 459 */       questionidlist.addAll(_o_.questionidlist);
/* 460 */       return questionidlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRightnum()
/*     */     {
/* 467 */       RoleWordQuestionInfo.this._xdb_verify_unsafe_();
/* 468 */       return RoleWordQuestionInfo.this.rightnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCuridx()
/*     */     {
/* 475 */       RoleWordQuestionInfo.this._xdb_verify_unsafe_();
/* 476 */       return RoleWordQuestionInfo.this.curidx;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 483 */       RoleWordQuestionInfo.this._xdb_verify_unsafe_();
/* 484 */       return RoleWordQuestionInfo.this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRightnum(int _v_)
/*     */     {
/* 491 */       RoleWordQuestionInfo.this._xdb_verify_unsafe_();
/* 492 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCuridx(int _v_)
/*     */     {
/* 499 */       RoleWordQuestionInfo.this._xdb_verify_unsafe_();
/* 500 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 507 */       RoleWordQuestionInfo.this._xdb_verify_unsafe_();
/* 508 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 514 */       RoleWordQuestionInfo.this._xdb_verify_unsafe_();
/* 515 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 521 */       RoleWordQuestionInfo.this._xdb_verify_unsafe_();
/* 522 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 528 */       return RoleWordQuestionInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 534 */       return RoleWordQuestionInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 540 */       RoleWordQuestionInfo.this._xdb_verify_unsafe_();
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 547 */       return RoleWordQuestionInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 553 */       return RoleWordQuestionInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 559 */       RoleWordQuestionInfo.this._xdb_verify_unsafe_();
/* 560 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 566 */       return RoleWordQuestionInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 572 */       return RoleWordQuestionInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 578 */       return RoleWordQuestionInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 584 */       return RoleWordQuestionInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 590 */       return RoleWordQuestionInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 596 */       return RoleWordQuestionInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 602 */       return RoleWordQuestionInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleWordQuestionInfo
/*     */   {
/*     */     private ArrayList<Integer> questionidlist;
/*     */     
/*     */     private int rightnum;
/*     */     
/*     */     private int curidx;
/*     */     
/*     */     private long sessionid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 620 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 625 */       this.questionidlist = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.RoleWordQuestionInfo _o1_)
/*     */     {
/* 630 */       if ((_o1_ instanceof RoleWordQuestionInfo)) { assign((RoleWordQuestionInfo)_o1_);
/* 631 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 632 */       } else if ((_o1_ instanceof RoleWordQuestionInfo.Const)) assign(((RoleWordQuestionInfo.Const)_o1_).nThis()); else {
/* 633 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleWordQuestionInfo _o_) {
/* 638 */       this.questionidlist = new ArrayList();
/* 639 */       this.questionidlist.addAll(_o_.questionidlist);
/* 640 */       this.rightnum = _o_.rightnum;
/* 641 */       this.curidx = _o_.curidx;
/* 642 */       this.sessionid = _o_.sessionid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 647 */       this.questionidlist = new ArrayList();
/* 648 */       this.questionidlist.addAll(_o_.questionidlist);
/* 649 */       this.rightnum = _o_.rightnum;
/* 650 */       this.curidx = _o_.curidx;
/* 651 */       this.sessionid = _o_.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 657 */       _os_.compact_uint32(this.questionidlist.size());
/* 658 */       for (Integer _v_ : this.questionidlist)
/*     */       {
/* 660 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 662 */       _os_.marshal(this.rightnum);
/* 663 */       _os_.marshal(this.curidx);
/* 664 */       _os_.marshal(this.sessionid);
/* 665 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 671 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 673 */         int _v_ = 0;
/* 674 */         _v_ = _os_.unmarshal_int();
/* 675 */         this.questionidlist.add(Integer.valueOf(_v_));
/*     */       }
/* 677 */       this.rightnum = _os_.unmarshal_int();
/* 678 */       this.curidx = _os_.unmarshal_int();
/* 679 */       this.sessionid = _os_.unmarshal_long();
/* 680 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 686 */       int _size_ = 0;
/* 687 */       for (Integer _v_ : this.questionidlist)
/*     */       {
/* 689 */         _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */       }
/* 691 */       _size_ += CodedOutputStream.computeInt32Size(2, this.rightnum);
/* 692 */       _size_ += CodedOutputStream.computeInt32Size(3, this.curidx);
/* 693 */       _size_ += CodedOutputStream.computeInt64Size(4, this.sessionid);
/* 694 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 702 */         for (Integer _v_ : this.questionidlist)
/*     */         {
/* 704 */           _output_.writeInt32(1, _v_.intValue());
/*     */         }
/* 706 */         _output_.writeInt32(2, this.rightnum);
/* 707 */         _output_.writeInt32(3, this.curidx);
/* 708 */         _output_.writeInt64(4, this.sessionid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 712 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 714 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 722 */         boolean done = false;
/* 723 */         while (!done)
/*     */         {
/* 725 */           int tag = _input_.readTag();
/* 726 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 730 */             done = true;
/* 731 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 735 */             int _v_ = 0;
/* 736 */             _v_ = _input_.readInt32();
/* 737 */             this.questionidlist.add(Integer.valueOf(_v_));
/* 738 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 742 */             this.rightnum = _input_.readInt32();
/* 743 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 747 */             this.curidx = _input_.readInt32();
/* 748 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 752 */             this.sessionid = _input_.readInt64();
/* 753 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 757 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 759 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 768 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 772 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 774 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleWordQuestionInfo copy()
/*     */     {
/* 780 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleWordQuestionInfo toData()
/*     */     {
/* 786 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleWordQuestionInfo toBean()
/*     */     {
/* 791 */       return new RoleWordQuestionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleWordQuestionInfo toDataIf()
/*     */     {
/* 797 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleWordQuestionInfo toBeanIf()
/*     */     {
/* 802 */       return new RoleWordQuestionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 808 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 812 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 816 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 820 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 824 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 828 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 832 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getQuestionidlist()
/*     */     {
/* 839 */       return this.questionidlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getQuestionidlistAsData()
/*     */     {
/* 846 */       return this.questionidlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRightnum()
/*     */     {
/* 853 */       return this.rightnum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCuridx()
/*     */     {
/* 860 */       return this.curidx;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 867 */       return this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRightnum(int _v_)
/*     */     {
/* 874 */       this.rightnum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCuridx(int _v_)
/*     */     {
/* 881 */       this.curidx = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 888 */       this.sessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 894 */       if (!(_o1_ instanceof Data)) return false;
/* 895 */       Data _o_ = (Data)_o1_;
/* 896 */       if (!this.questionidlist.equals(_o_.questionidlist)) return false;
/* 897 */       if (this.rightnum != _o_.rightnum) return false;
/* 898 */       if (this.curidx != _o_.curidx) return false;
/* 899 */       if (this.sessionid != _o_.sessionid) return false;
/* 900 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 906 */       int _h_ = 0;
/* 907 */       _h_ += this.questionidlist.hashCode();
/* 908 */       _h_ += this.rightnum;
/* 909 */       _h_ += this.curidx;
/* 910 */       _h_ = (int)(_h_ + this.sessionid);
/* 911 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 917 */       StringBuilder _sb_ = new StringBuilder();
/* 918 */       _sb_.append("(");
/* 919 */       _sb_.append(this.questionidlist);
/* 920 */       _sb_.append(",");
/* 921 */       _sb_.append(this.rightnum);
/* 922 */       _sb_.append(",");
/* 923 */       _sb_.append(this.curidx);
/* 924 */       _sb_.append(",");
/* 925 */       _sb_.append(this.sessionid);
/* 926 */       _sb_.append(")");
/* 927 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleWordQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */