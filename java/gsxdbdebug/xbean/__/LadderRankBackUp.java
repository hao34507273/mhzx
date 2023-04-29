/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class LadderRankBackUp extends XBean implements xbean.LadderRankBackUp
/*     */ {
/*     */   private LinkedList<xbean.LadderRankRole> ranklist;
/*     */   private long backuptime;
/*     */   private SetX<Long> remoteawardroles;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.ranklist.clear();
/*  23 */     this.backuptime = 0L;
/*  24 */     this.remoteawardroles.clear();
/*     */   }
/*     */   
/*     */   LadderRankBackUp(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.ranklist = new LinkedList();
/*  31 */     this.remoteawardroles = new SetX();
/*     */   }
/*     */   
/*     */   public LadderRankBackUp()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public LadderRankBackUp(LadderRankBackUp _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   LadderRankBackUp(xbean.LadderRankBackUp _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof LadderRankBackUp)) { assign((LadderRankBackUp)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(LadderRankBackUp _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.ranklist = new LinkedList();
/*  57 */     for (xbean.LadderRankRole _v_ : _o_.ranklist)
/*  58 */       this.ranklist.add(new LadderRankRole(_v_, this, "ranklist"));
/*  59 */     this.backuptime = _o_.backuptime;
/*  60 */     this.remoteawardroles = new SetX();
/*  61 */     this.remoteawardroles.addAll(_o_.remoteawardroles);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.ranklist = new LinkedList();
/*  67 */     for (xbean.LadderRankRole _v_ : _o_.ranklist)
/*  68 */       this.ranklist.add(new LadderRankRole(_v_, this, "ranklist"));
/*  69 */     this.backuptime = _o_.backuptime;
/*  70 */     this.remoteawardroles = new SetX();
/*  71 */     this.remoteawardroles.addAll(_o_.remoteawardroles);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*  78 */     _os_.compact_uint32(this.ranklist.size());
/*  79 */     for (xbean.LadderRankRole _v_ : this.ranklist)
/*     */     {
/*  81 */       _v_.marshal(_os_);
/*     */     }
/*  83 */     _os_.marshal(this.backuptime);
/*  84 */     _os_.compact_uint32(this.remoteawardroles.size());
/*  85 */     for (Long _v_ : this.remoteawardroles)
/*     */     {
/*  87 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  98 */       xbean.LadderRankRole _v_ = new LadderRankRole(0, this, "ranklist");
/*  99 */       _v_.unmarshal(_os_);
/* 100 */       this.ranklist.add(_v_);
/*     */     }
/* 102 */     this.backuptime = _os_.unmarshal_long();
/* 103 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 105 */       long _v_ = 0L;
/* 106 */       _v_ = _os_.unmarshal_long();
/* 107 */       this.remoteawardroles.add(Long.valueOf(_v_));
/*     */     }
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 115 */     _xdb_verify_unsafe_();
/* 116 */     int _size_ = 0;
/* 117 */     for (xbean.LadderRankRole _v_ : this.ranklist)
/*     */     {
/* 119 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/* 121 */     _size_ += CodedOutputStream.computeInt64Size(2, this.backuptime);
/* 122 */     for (Long _v_ : this.remoteawardroles)
/*     */     {
/* 124 */       _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*     */     }
/* 126 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 132 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 135 */       for (xbean.LadderRankRole _v_ : this.ranklist)
/*     */       {
/* 137 */         _output_.writeMessage(1, _v_);
/*     */       }
/* 139 */       _output_.writeInt64(2, this.backuptime);
/* 140 */       for (Long _v_ : this.remoteawardroles)
/*     */       {
/* 142 */         _output_.writeInt64(3, _v_.longValue());
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 147 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 149 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 155 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 158 */       boolean done = false;
/* 159 */       while (!done)
/*     */       {
/* 161 */         int tag = _input_.readTag();
/* 162 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 166 */           done = true;
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 171 */           xbean.LadderRankRole _v_ = new LadderRankRole(0, this, "ranklist");
/* 172 */           _input_.readMessage(_v_);
/* 173 */           this.ranklist.add(_v_);
/* 174 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 178 */           this.backuptime = _input_.readInt64();
/* 179 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 183 */           long _v_ = 0L;
/* 184 */           _v_ = _input_.readInt64();
/* 185 */           this.remoteawardroles.add(Long.valueOf(_v_));
/* 186 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 190 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 192 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 201 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 205 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 207 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LadderRankBackUp copy()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new LadderRankBackUp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LadderRankBackUp toData()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LadderRankBackUp toBean()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new LadderRankBackUp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LadderRankBackUp toDataIf()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LadderRankBackUp toBeanIf()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.LadderRankRole> getRanklist()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return xdb.Logs.logList(new xdb.LogKey(this, "ranklist"), this.ranklist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.LadderRankRole> getRanklistAsData()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/*     */     
/* 263 */     LadderRankBackUp _o_ = this;
/* 264 */     List<xbean.LadderRankRole> ranklist = new LinkedList();
/* 265 */     for (xbean.LadderRankRole _v_ : _o_.ranklist)
/* 266 */       ranklist.add(new LadderRankRole.Data(_v_));
/* 267 */     return ranklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getBackuptime()
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     return this.backuptime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getRemoteawardroles()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/* 283 */     return xdb.Logs.logSet(new xdb.LogKey(this, "remoteawardroles"), this.remoteawardroles);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getRemoteawardrolesAsData()
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/*     */     
/* 291 */     LadderRankBackUp _o_ = this;
/* 292 */     Set<Long> remoteawardroles = new SetX();
/* 293 */     remoteawardroles.addAll(_o_.remoteawardroles);
/* 294 */     return remoteawardroles;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBackuptime(long _v_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     xdb.Logs.logIf(new xdb.LogKey(this, "backuptime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 306 */         new xdb.logs.LogLong(this, LadderRankBackUp.this.backuptime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             LadderRankBackUp.this.backuptime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.backuptime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     LadderRankBackUp _o_ = null;
/* 323 */     if ((_o1_ instanceof LadderRankBackUp)) { _o_ = (LadderRankBackUp)_o1_;
/* 324 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 325 */       return false;
/* 326 */     if (!this.ranklist.equals(_o_.ranklist)) return false;
/* 327 */     if (this.backuptime != _o_.backuptime) return false;
/* 328 */     if (!this.remoteawardroles.equals(_o_.remoteawardroles)) return false;
/* 329 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 335 */     _xdb_verify_unsafe_();
/* 336 */     int _h_ = 0;
/* 337 */     _h_ += this.ranklist.hashCode();
/* 338 */     _h_ = (int)(_h_ + this.backuptime);
/* 339 */     _h_ += this.remoteawardroles.hashCode();
/* 340 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 346 */     _xdb_verify_unsafe_();
/* 347 */     StringBuilder _sb_ = new StringBuilder();
/* 348 */     _sb_.append("(");
/* 349 */     _sb_.append(this.ranklist);
/* 350 */     _sb_.append(",");
/* 351 */     _sb_.append(this.backuptime);
/* 352 */     _sb_.append(",");
/* 353 */     _sb_.append(this.remoteawardroles);
/* 354 */     _sb_.append(")");
/* 355 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 361 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 362 */     lb.add(new xdb.logs.ListenableChanged().setVarName("ranklist"));
/* 363 */     lb.add(new xdb.logs.ListenableChanged().setVarName("backuptime"));
/* 364 */     lb.add(new xdb.logs.ListenableSet().setVarName("remoteawardroles"));
/* 365 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.LadderRankBackUp {
/*     */     private Const() {}
/*     */     
/*     */     LadderRankBackUp nThis() {
/* 372 */       return LadderRankBackUp.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 378 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LadderRankBackUp copy()
/*     */     {
/* 384 */       return LadderRankBackUp.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LadderRankBackUp toData()
/*     */     {
/* 390 */       return LadderRankBackUp.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.LadderRankBackUp toBean()
/*     */     {
/* 395 */       return LadderRankBackUp.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LadderRankBackUp toDataIf()
/*     */     {
/* 401 */       return LadderRankBackUp.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.LadderRankBackUp toBeanIf()
/*     */     {
/* 406 */       return LadderRankBackUp.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.LadderRankRole> getRanklist()
/*     */     {
/* 413 */       LadderRankBackUp.this._xdb_verify_unsafe_();
/* 414 */       return xdb.Consts.constList(LadderRankBackUp.this.ranklist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.LadderRankRole> getRanklistAsData()
/*     */     {
/* 420 */       LadderRankBackUp.this._xdb_verify_unsafe_();
/*     */       
/* 422 */       LadderRankBackUp _o_ = LadderRankBackUp.this;
/* 423 */       List<xbean.LadderRankRole> ranklist = new LinkedList();
/* 424 */       for (xbean.LadderRankRole _v_ : _o_.ranklist)
/* 425 */         ranklist.add(new LadderRankRole.Data(_v_));
/* 426 */       return ranklist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getBackuptime()
/*     */     {
/* 433 */       LadderRankBackUp.this._xdb_verify_unsafe_();
/* 434 */       return LadderRankBackUp.this.backuptime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getRemoteawardroles()
/*     */     {
/* 441 */       LadderRankBackUp.this._xdb_verify_unsafe_();
/* 442 */       return xdb.Consts.constSet(LadderRankBackUp.this.remoteawardroles);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getRemoteawardrolesAsData()
/*     */     {
/* 448 */       LadderRankBackUp.this._xdb_verify_unsafe_();
/*     */       
/* 450 */       LadderRankBackUp _o_ = LadderRankBackUp.this;
/* 451 */       Set<Long> remoteawardroles = new SetX();
/* 452 */       remoteawardroles.addAll(_o_.remoteawardroles);
/* 453 */       return remoteawardroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBackuptime(long _v_)
/*     */     {
/* 460 */       LadderRankBackUp.this._xdb_verify_unsafe_();
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 467 */       LadderRankBackUp.this._xdb_verify_unsafe_();
/* 468 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 474 */       LadderRankBackUp.this._xdb_verify_unsafe_();
/* 475 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 481 */       return LadderRankBackUp.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 487 */       return LadderRankBackUp.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 493 */       LadderRankBackUp.this._xdb_verify_unsafe_();
/* 494 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 500 */       return LadderRankBackUp.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 506 */       return LadderRankBackUp.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 512 */       LadderRankBackUp.this._xdb_verify_unsafe_();
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 519 */       return LadderRankBackUp.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 525 */       return LadderRankBackUp.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 531 */       return LadderRankBackUp.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 537 */       return LadderRankBackUp.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 543 */       return LadderRankBackUp.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 549 */       return LadderRankBackUp.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 555 */       return LadderRankBackUp.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.LadderRankBackUp
/*     */   {
/*     */     private LinkedList<xbean.LadderRankRole> ranklist;
/*     */     
/*     */     private long backuptime;
/*     */     
/*     */     private HashSet<Long> remoteawardroles;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 571 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 576 */       this.ranklist = new LinkedList();
/* 577 */       this.remoteawardroles = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.LadderRankBackUp _o1_)
/*     */     {
/* 582 */       if ((_o1_ instanceof LadderRankBackUp)) { assign((LadderRankBackUp)_o1_);
/* 583 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 584 */       } else if ((_o1_ instanceof LadderRankBackUp.Const)) assign(((LadderRankBackUp.Const)_o1_).nThis()); else {
/* 585 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(LadderRankBackUp _o_) {
/* 590 */       this.ranklist = new LinkedList();
/* 591 */       for (xbean.LadderRankRole _v_ : _o_.ranklist)
/* 592 */         this.ranklist.add(new LadderRankRole.Data(_v_));
/* 593 */       this.backuptime = _o_.backuptime;
/* 594 */       this.remoteawardroles = new HashSet();
/* 595 */       this.remoteawardroles.addAll(_o_.remoteawardroles);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 600 */       this.ranklist = new LinkedList();
/* 601 */       for (xbean.LadderRankRole _v_ : _o_.ranklist)
/* 602 */         this.ranklist.add(new LadderRankRole.Data(_v_));
/* 603 */       this.backuptime = _o_.backuptime;
/* 604 */       this.remoteawardroles = new HashSet();
/* 605 */       this.remoteawardroles.addAll(_o_.remoteawardroles);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 611 */       _os_.compact_uint32(this.ranklist.size());
/* 612 */       for (xbean.LadderRankRole _v_ : this.ranklist)
/*     */       {
/* 614 */         _v_.marshal(_os_);
/*     */       }
/* 616 */       _os_.marshal(this.backuptime);
/* 617 */       _os_.compact_uint32(this.remoteawardroles.size());
/* 618 */       for (Long _v_ : this.remoteawardroles)
/*     */       {
/* 620 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 622 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 628 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 630 */         xbean.LadderRankRole _v_ = xbean.Pod.newLadderRankRoleData();
/* 631 */         _v_.unmarshal(_os_);
/* 632 */         this.ranklist.add(_v_);
/*     */       }
/* 634 */       this.backuptime = _os_.unmarshal_long();
/* 635 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 637 */         long _v_ = 0L;
/* 638 */         _v_ = _os_.unmarshal_long();
/* 639 */         this.remoteawardroles.add(Long.valueOf(_v_));
/*     */       }
/* 641 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 647 */       int _size_ = 0;
/* 648 */       for (xbean.LadderRankRole _v_ : this.ranklist)
/*     */       {
/* 650 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 652 */       _size_ += CodedOutputStream.computeInt64Size(2, this.backuptime);
/* 653 */       for (Long _v_ : this.remoteawardroles)
/*     */       {
/* 655 */         _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*     */       }
/* 657 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 665 */         for (xbean.LadderRankRole _v_ : this.ranklist)
/*     */         {
/* 667 */           _output_.writeMessage(1, _v_);
/*     */         }
/* 669 */         _output_.writeInt64(2, this.backuptime);
/* 670 */         for (Long _v_ : this.remoteawardroles)
/*     */         {
/* 672 */           _output_.writeInt64(3, _v_.longValue());
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 677 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 679 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 687 */         boolean done = false;
/* 688 */         while (!done)
/*     */         {
/* 690 */           int tag = _input_.readTag();
/* 691 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 695 */             done = true;
/* 696 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 700 */             xbean.LadderRankRole _v_ = xbean.Pod.newLadderRankRoleData();
/* 701 */             _input_.readMessage(_v_);
/* 702 */             this.ranklist.add(_v_);
/* 703 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 707 */             this.backuptime = _input_.readInt64();
/* 708 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 712 */             long _v_ = 0L;
/* 713 */             _v_ = _input_.readInt64();
/* 714 */             this.remoteawardroles.add(Long.valueOf(_v_));
/* 715 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 719 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 721 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 730 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 734 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 736 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LadderRankBackUp copy()
/*     */     {
/* 742 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LadderRankBackUp toData()
/*     */     {
/* 748 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.LadderRankBackUp toBean()
/*     */     {
/* 753 */       return new LadderRankBackUp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LadderRankBackUp toDataIf()
/*     */     {
/* 759 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.LadderRankBackUp toBeanIf()
/*     */     {
/* 764 */       return new LadderRankBackUp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 770 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 774 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 778 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 782 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 786 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 790 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 794 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.LadderRankRole> getRanklist()
/*     */     {
/* 801 */       return this.ranklist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.LadderRankRole> getRanklistAsData()
/*     */     {
/* 808 */       return this.ranklist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getBackuptime()
/*     */     {
/* 815 */       return this.backuptime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getRemoteawardroles()
/*     */     {
/* 822 */       return this.remoteawardroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getRemoteawardrolesAsData()
/*     */     {
/* 829 */       return this.remoteawardroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBackuptime(long _v_)
/*     */     {
/* 836 */       this.backuptime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 842 */       if (!(_o1_ instanceof Data)) return false;
/* 843 */       Data _o_ = (Data)_o1_;
/* 844 */       if (!this.ranklist.equals(_o_.ranklist)) return false;
/* 845 */       if (this.backuptime != _o_.backuptime) return false;
/* 846 */       if (!this.remoteawardroles.equals(_o_.remoteawardroles)) return false;
/* 847 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 853 */       int _h_ = 0;
/* 854 */       _h_ += this.ranklist.hashCode();
/* 855 */       _h_ = (int)(_h_ + this.backuptime);
/* 856 */       _h_ += this.remoteawardroles.hashCode();
/* 857 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 863 */       StringBuilder _sb_ = new StringBuilder();
/* 864 */       _sb_.append("(");
/* 865 */       _sb_.append(this.ranklist);
/* 866 */       _sb_.append(",");
/* 867 */       _sb_.append(this.backuptime);
/* 868 */       _sb_.append(",");
/* 869 */       _sb_.append(this.remoteawardroles);
/* 870 */       _sb_.append(")");
/* 871 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\LadderRankBackUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */