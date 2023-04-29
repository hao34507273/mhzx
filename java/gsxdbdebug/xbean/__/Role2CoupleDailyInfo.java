/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class Role2CoupleDailyInfo extends XBean implements xbean.Role2CoupleDailyInfo
/*     */ {
/*     */   private LinkedList<xbean.TaskInfo> tasklist;
/*     */   private int isawarded;
/*     */   private long partnerroleid;
/*     */   private xbean.CoupleQuestionInfo couplequestioninfo;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.tasklist.clear();
/*  25 */     this.isawarded = 0;
/*  26 */     this.partnerroleid = 0L;
/*  27 */     this.couplequestioninfo._reset_unsafe_();
/*     */   }
/*     */   
/*     */   Role2CoupleDailyInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.tasklist = new LinkedList();
/*  34 */     this.couplequestioninfo = new CoupleQuestionInfo(0, this, "couplequestioninfo");
/*     */   }
/*     */   
/*     */   public Role2CoupleDailyInfo()
/*     */   {
/*  39 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Role2CoupleDailyInfo(Role2CoupleDailyInfo _o_)
/*     */   {
/*  44 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Role2CoupleDailyInfo(xbean.Role2CoupleDailyInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  49 */     super(_xp_, _vn_);
/*  50 */     if ((_o1_ instanceof Role2CoupleDailyInfo)) { assign((Role2CoupleDailyInfo)_o1_);
/*  51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  53 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Role2CoupleDailyInfo _o_) {
/*  58 */     _o_._xdb_verify_unsafe_();
/*  59 */     this.tasklist = new LinkedList();
/*  60 */     for (xbean.TaskInfo _v_ : _o_.tasklist)
/*  61 */       this.tasklist.add(new TaskInfo(_v_, this, "tasklist"));
/*  62 */     this.isawarded = _o_.isawarded;
/*  63 */     this.partnerroleid = _o_.partnerroleid;
/*  64 */     this.couplequestioninfo = new CoupleQuestionInfo(_o_.couplequestioninfo, this, "couplequestioninfo");
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.tasklist = new LinkedList();
/*  70 */     for (xbean.TaskInfo _v_ : _o_.tasklist)
/*  71 */       this.tasklist.add(new TaskInfo(_v_, this, "tasklist"));
/*  72 */     this.isawarded = _o_.isawarded;
/*  73 */     this.partnerroleid = _o_.partnerroleid;
/*  74 */     this.couplequestioninfo = new CoupleQuestionInfo(_o_.couplequestioninfo, this, "couplequestioninfo");
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     _os_.compact_uint32(this.tasklist.size());
/*  82 */     for (xbean.TaskInfo _v_ : this.tasklist)
/*     */     {
/*  84 */       _v_.marshal(_os_);
/*     */     }
/*  86 */     _os_.marshal(this.isawarded);
/*  87 */     _os_.marshal(this.partnerroleid);
/*  88 */     this.couplequestioninfo.marshal(_os_);
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  98 */       xbean.TaskInfo _v_ = new TaskInfo(0, this, "tasklist");
/*  99 */       _v_.unmarshal(_os_);
/* 100 */       this.tasklist.add(_v_);
/*     */     }
/* 102 */     this.isawarded = _os_.unmarshal_int();
/* 103 */     this.partnerroleid = _os_.unmarshal_long();
/* 104 */     this.couplequestioninfo.unmarshal(_os_);
/* 105 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 111 */     _xdb_verify_unsafe_();
/* 112 */     int _size_ = 0;
/* 113 */     for (xbean.TaskInfo _v_ : this.tasklist)
/*     */     {
/* 115 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/* 117 */     _size_ += CodedOutputStream.computeInt32Size(2, this.isawarded);
/* 118 */     _size_ += CodedOutputStream.computeInt64Size(3, this.partnerroleid);
/* 119 */     _size_ += CodedOutputStream.computeMessageSize(4, this.couplequestioninfo);
/* 120 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       for (xbean.TaskInfo _v_ : this.tasklist)
/*     */       {
/* 131 */         _output_.writeMessage(1, _v_);
/*     */       }
/* 133 */       _output_.writeInt32(2, this.isawarded);
/* 134 */       _output_.writeInt64(3, this.partnerroleid);
/* 135 */       _output_.writeMessage(4, this.couplequestioninfo);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 139 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 141 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 147 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 150 */       boolean done = false;
/* 151 */       while (!done)
/*     */       {
/* 153 */         int tag = _input_.readTag();
/* 154 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 158 */           done = true;
/* 159 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 163 */           xbean.TaskInfo _v_ = new TaskInfo(0, this, "tasklist");
/* 164 */           _input_.readMessage(_v_);
/* 165 */           this.tasklist.add(_v_);
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 170 */           this.isawarded = _input_.readInt32();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 175 */           this.partnerroleid = _input_.readInt64();
/* 176 */           break;
/*     */         
/*     */ 
/*     */         case 34: 
/* 180 */           _input_.readMessage(this.couplequestioninfo);
/* 181 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 185 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 187 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 196 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 200 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 202 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2CoupleDailyInfo copy()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return new Role2CoupleDailyInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2CoupleDailyInfo toData()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2CoupleDailyInfo toBean()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return new Role2CoupleDailyInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2CoupleDailyInfo toDataIf()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2CoupleDailyInfo toBeanIf()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 241 */     _xdb_verify_unsafe_();
/* 242 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.TaskInfo> getTasklist()
/*     */   {
/* 249 */     _xdb_verify_unsafe_();
/* 250 */     return xdb.Logs.logList(new LogKey(this, "tasklist"), this.tasklist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.TaskInfo> getTasklistAsData()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/*     */     
/* 258 */     Role2CoupleDailyInfo _o_ = this;
/* 259 */     List<xbean.TaskInfo> tasklist = new LinkedList();
/* 260 */     for (xbean.TaskInfo _v_ : _o_.tasklist)
/* 261 */       tasklist.add(new TaskInfo.Data(_v_));
/* 262 */     return tasklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getIsawarded()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return this.isawarded;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getPartnerroleid()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/* 278 */     return this.partnerroleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.CoupleQuestionInfo getCouplequestioninfo()
/*     */   {
/* 285 */     _xdb_verify_unsafe_();
/* 286 */     return this.couplequestioninfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIsawarded(int _v_)
/*     */   {
/* 293 */     _xdb_verify_unsafe_();
/* 294 */     xdb.Logs.logIf(new LogKey(this, "isawarded")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 298 */         new xdb.logs.LogInt(this, Role2CoupleDailyInfo.this.isawarded)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 302 */             Role2CoupleDailyInfo.this.isawarded = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 306 */     });
/* 307 */     this.isawarded = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPartnerroleid(long _v_)
/*     */   {
/* 314 */     _xdb_verify_unsafe_();
/* 315 */     xdb.Logs.logIf(new LogKey(this, "partnerroleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 319 */         new xdb.logs.LogLong(this, Role2CoupleDailyInfo.this.partnerroleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 323 */             Role2CoupleDailyInfo.this.partnerroleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 327 */     });
/* 328 */     this.partnerroleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 334 */     _xdb_verify_unsafe_();
/* 335 */     Role2CoupleDailyInfo _o_ = null;
/* 336 */     if ((_o1_ instanceof Role2CoupleDailyInfo)) { _o_ = (Role2CoupleDailyInfo)_o1_;
/* 337 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 338 */       return false;
/* 339 */     if (!this.tasklist.equals(_o_.tasklist)) return false;
/* 340 */     if (this.isawarded != _o_.isawarded) return false;
/* 341 */     if (this.partnerroleid != _o_.partnerroleid) return false;
/* 342 */     if (!this.couplequestioninfo.equals(_o_.couplequestioninfo)) return false;
/* 343 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 349 */     _xdb_verify_unsafe_();
/* 350 */     int _h_ = 0;
/* 351 */     _h_ += this.tasklist.hashCode();
/* 352 */     _h_ += this.isawarded;
/* 353 */     _h_ = (int)(_h_ + this.partnerroleid);
/* 354 */     _h_ += this.couplequestioninfo.hashCode();
/* 355 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 361 */     _xdb_verify_unsafe_();
/* 362 */     StringBuilder _sb_ = new StringBuilder();
/* 363 */     _sb_.append("(");
/* 364 */     _sb_.append(this.tasklist);
/* 365 */     _sb_.append(",");
/* 366 */     _sb_.append(this.isawarded);
/* 367 */     _sb_.append(",");
/* 368 */     _sb_.append(this.partnerroleid);
/* 369 */     _sb_.append(",");
/* 370 */     _sb_.append(this.couplequestioninfo);
/* 371 */     _sb_.append(")");
/* 372 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 378 */     ListenableBean lb = new ListenableBean();
/* 379 */     lb.add(new ListenableChanged().setVarName("tasklist"));
/* 380 */     lb.add(new ListenableChanged().setVarName("isawarded"));
/* 381 */     lb.add(new ListenableChanged().setVarName("partnerroleid"));
/* 382 */     lb.add(new ListenableChanged().setVarName("couplequestioninfo"));
/* 383 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Role2CoupleDailyInfo {
/*     */     private Const() {}
/*     */     
/*     */     Role2CoupleDailyInfo nThis() {
/* 390 */       return Role2CoupleDailyInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 396 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2CoupleDailyInfo copy()
/*     */     {
/* 402 */       return Role2CoupleDailyInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2CoupleDailyInfo toData()
/*     */     {
/* 408 */       return Role2CoupleDailyInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Role2CoupleDailyInfo toBean()
/*     */     {
/* 413 */       return Role2CoupleDailyInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2CoupleDailyInfo toDataIf()
/*     */     {
/* 419 */       return Role2CoupleDailyInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Role2CoupleDailyInfo toBeanIf()
/*     */     {
/* 424 */       return Role2CoupleDailyInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.TaskInfo> getTasklist()
/*     */     {
/* 431 */       Role2CoupleDailyInfo.this._xdb_verify_unsafe_();
/* 432 */       return xdb.Consts.constList(Role2CoupleDailyInfo.this.tasklist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.TaskInfo> getTasklistAsData()
/*     */     {
/* 438 */       Role2CoupleDailyInfo.this._xdb_verify_unsafe_();
/*     */       
/* 440 */       Role2CoupleDailyInfo _o_ = Role2CoupleDailyInfo.this;
/* 441 */       List<xbean.TaskInfo> tasklist = new LinkedList();
/* 442 */       for (xbean.TaskInfo _v_ : _o_.tasklist)
/* 443 */         tasklist.add(new TaskInfo.Data(_v_));
/* 444 */       return tasklist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIsawarded()
/*     */     {
/* 451 */       Role2CoupleDailyInfo.this._xdb_verify_unsafe_();
/* 452 */       return Role2CoupleDailyInfo.this.isawarded;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPartnerroleid()
/*     */     {
/* 459 */       Role2CoupleDailyInfo.this._xdb_verify_unsafe_();
/* 460 */       return Role2CoupleDailyInfo.this.partnerroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.CoupleQuestionInfo getCouplequestioninfo()
/*     */     {
/* 467 */       Role2CoupleDailyInfo.this._xdb_verify_unsafe_();
/* 468 */       return (xbean.CoupleQuestionInfo)xdb.Consts.toConst(Role2CoupleDailyInfo.this.couplequestioninfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsawarded(int _v_)
/*     */     {
/* 475 */       Role2CoupleDailyInfo.this._xdb_verify_unsafe_();
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPartnerroleid(long _v_)
/*     */     {
/* 483 */       Role2CoupleDailyInfo.this._xdb_verify_unsafe_();
/* 484 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 490 */       Role2CoupleDailyInfo.this._xdb_verify_unsafe_();
/* 491 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 497 */       Role2CoupleDailyInfo.this._xdb_verify_unsafe_();
/* 498 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 504 */       return Role2CoupleDailyInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 510 */       return Role2CoupleDailyInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 516 */       Role2CoupleDailyInfo.this._xdb_verify_unsafe_();
/* 517 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 523 */       return Role2CoupleDailyInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 529 */       return Role2CoupleDailyInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 535 */       Role2CoupleDailyInfo.this._xdb_verify_unsafe_();
/* 536 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 542 */       return Role2CoupleDailyInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 548 */       return Role2CoupleDailyInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 554 */       return Role2CoupleDailyInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 560 */       return Role2CoupleDailyInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 566 */       return Role2CoupleDailyInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 572 */       return Role2CoupleDailyInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 578 */       return Role2CoupleDailyInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Role2CoupleDailyInfo
/*     */   {
/*     */     private LinkedList<xbean.TaskInfo> tasklist;
/*     */     
/*     */     private int isawarded;
/*     */     
/*     */     private long partnerroleid;
/*     */     
/*     */     private xbean.CoupleQuestionInfo couplequestioninfo;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 596 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 601 */       this.tasklist = new LinkedList();
/* 602 */       this.couplequestioninfo = new CoupleQuestionInfo.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.Role2CoupleDailyInfo _o1_)
/*     */     {
/* 607 */       if ((_o1_ instanceof Role2CoupleDailyInfo)) { assign((Role2CoupleDailyInfo)_o1_);
/* 608 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 609 */       } else if ((_o1_ instanceof Role2CoupleDailyInfo.Const)) assign(((Role2CoupleDailyInfo.Const)_o1_).nThis()); else {
/* 610 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Role2CoupleDailyInfo _o_) {
/* 615 */       this.tasklist = new LinkedList();
/* 616 */       for (xbean.TaskInfo _v_ : _o_.tasklist)
/* 617 */         this.tasklist.add(new TaskInfo.Data(_v_));
/* 618 */       this.isawarded = _o_.isawarded;
/* 619 */       this.partnerroleid = _o_.partnerroleid;
/* 620 */       this.couplequestioninfo = new CoupleQuestionInfo.Data(_o_.couplequestioninfo);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 625 */       this.tasklist = new LinkedList();
/* 626 */       for (xbean.TaskInfo _v_ : _o_.tasklist)
/* 627 */         this.tasklist.add(new TaskInfo.Data(_v_));
/* 628 */       this.isawarded = _o_.isawarded;
/* 629 */       this.partnerroleid = _o_.partnerroleid;
/* 630 */       this.couplequestioninfo = new CoupleQuestionInfo.Data(_o_.couplequestioninfo);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 636 */       _os_.compact_uint32(this.tasklist.size());
/* 637 */       for (xbean.TaskInfo _v_ : this.tasklist)
/*     */       {
/* 639 */         _v_.marshal(_os_);
/*     */       }
/* 641 */       _os_.marshal(this.isawarded);
/* 642 */       _os_.marshal(this.partnerroleid);
/* 643 */       this.couplequestioninfo.marshal(_os_);
/* 644 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 650 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 652 */         xbean.TaskInfo _v_ = xbean.Pod.newTaskInfoData();
/* 653 */         _v_.unmarshal(_os_);
/* 654 */         this.tasklist.add(_v_);
/*     */       }
/* 656 */       this.isawarded = _os_.unmarshal_int();
/* 657 */       this.partnerroleid = _os_.unmarshal_long();
/* 658 */       this.couplequestioninfo.unmarshal(_os_);
/* 659 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 665 */       int _size_ = 0;
/* 666 */       for (xbean.TaskInfo _v_ : this.tasklist)
/*     */       {
/* 668 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 670 */       _size_ += CodedOutputStream.computeInt32Size(2, this.isawarded);
/* 671 */       _size_ += CodedOutputStream.computeInt64Size(3, this.partnerroleid);
/* 672 */       _size_ += CodedOutputStream.computeMessageSize(4, this.couplequestioninfo);
/* 673 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 681 */         for (xbean.TaskInfo _v_ : this.tasklist)
/*     */         {
/* 683 */           _output_.writeMessage(1, _v_);
/*     */         }
/* 685 */         _output_.writeInt32(2, this.isawarded);
/* 686 */         _output_.writeInt64(3, this.partnerroleid);
/* 687 */         _output_.writeMessage(4, this.couplequestioninfo);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 691 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 693 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 701 */         boolean done = false;
/* 702 */         while (!done)
/*     */         {
/* 704 */           int tag = _input_.readTag();
/* 705 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 709 */             done = true;
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 714 */             xbean.TaskInfo _v_ = xbean.Pod.newTaskInfoData();
/* 715 */             _input_.readMessage(_v_);
/* 716 */             this.tasklist.add(_v_);
/* 717 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 721 */             this.isawarded = _input_.readInt32();
/* 722 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 726 */             this.partnerroleid = _input_.readInt64();
/* 727 */             break;
/*     */           
/*     */ 
/*     */           case 34: 
/* 731 */             _input_.readMessage(this.couplequestioninfo);
/* 732 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 736 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 738 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 747 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 751 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 753 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2CoupleDailyInfo copy()
/*     */     {
/* 759 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2CoupleDailyInfo toData()
/*     */     {
/* 765 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Role2CoupleDailyInfo toBean()
/*     */     {
/* 770 */       return new Role2CoupleDailyInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2CoupleDailyInfo toDataIf()
/*     */     {
/* 776 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Role2CoupleDailyInfo toBeanIf()
/*     */     {
/* 781 */       return new Role2CoupleDailyInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 795 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 799 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 803 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 807 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 811 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.TaskInfo> getTasklist()
/*     */     {
/* 818 */       return this.tasklist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.TaskInfo> getTasklistAsData()
/*     */     {
/* 825 */       return this.tasklist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIsawarded()
/*     */     {
/* 832 */       return this.isawarded;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPartnerroleid()
/*     */     {
/* 839 */       return this.partnerroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.CoupleQuestionInfo getCouplequestioninfo()
/*     */     {
/* 846 */       return this.couplequestioninfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsawarded(int _v_)
/*     */     {
/* 853 */       this.isawarded = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPartnerroleid(long _v_)
/*     */     {
/* 860 */       this.partnerroleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 866 */       if (!(_o1_ instanceof Data)) return false;
/* 867 */       Data _o_ = (Data)_o1_;
/* 868 */       if (!this.tasklist.equals(_o_.tasklist)) return false;
/* 869 */       if (this.isawarded != _o_.isawarded) return false;
/* 870 */       if (this.partnerroleid != _o_.partnerroleid) return false;
/* 871 */       if (!this.couplequestioninfo.equals(_o_.couplequestioninfo)) return false;
/* 872 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 878 */       int _h_ = 0;
/* 879 */       _h_ += this.tasklist.hashCode();
/* 880 */       _h_ += this.isawarded;
/* 881 */       _h_ = (int)(_h_ + this.partnerroleid);
/* 882 */       _h_ += this.couplequestioninfo.hashCode();
/* 883 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 889 */       StringBuilder _sb_ = new StringBuilder();
/* 890 */       _sb_.append("(");
/* 891 */       _sb_.append(this.tasklist);
/* 892 */       _sb_.append(",");
/* 893 */       _sb_.append(this.isawarded);
/* 894 */       _sb_.append(",");
/* 895 */       _sb_.append(this.partnerroleid);
/* 896 */       _sb_.append(",");
/* 897 */       _sb_.append(this.couplequestioninfo);
/* 898 */       _sb_.append(")");
/* 899 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2CoupleDailyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */