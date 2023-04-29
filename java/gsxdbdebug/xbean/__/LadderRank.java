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
/*     */ 
/*     */ public final class LadderRank extends XBean implements xbean.LadderRank
/*     */ {
/*     */   private LinkedList<xbean.LadderRankRole> ranklist;
/*     */   private long inittime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.ranklist.clear();
/*  21 */     this.inittime = 0L;
/*     */   }
/*     */   
/*     */   LadderRank(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.ranklist = new LinkedList();
/*     */   }
/*     */   
/*     */   public LadderRank()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public LadderRank(LadderRank _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   LadderRank(xbean.LadderRank _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof LadderRank)) { assign((LadderRank)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(LadderRank _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.ranklist = new LinkedList();
/*  53 */     for (xbean.LadderRankRole _v_ : _o_.ranklist)
/*  54 */       this.ranklist.add(new LadderRankRole(_v_, this, "ranklist"));
/*  55 */     this.inittime = _o_.inittime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  60 */     this.ranklist = new LinkedList();
/*  61 */     for (xbean.LadderRankRole _v_ : _o_.ranklist)
/*  62 */       this.ranklist.add(new LadderRankRole(_v_, this, "ranklist"));
/*  63 */     this.inittime = _o_.inittime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.compact_uint32(this.ranklist.size());
/*  71 */     for (xbean.LadderRankRole _v_ : this.ranklist)
/*     */     {
/*  73 */       _v_.marshal(_os_);
/*     */     }
/*  75 */     _os_.marshal(this.inittime);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  85 */       xbean.LadderRankRole _v_ = new LadderRankRole(0, this, "ranklist");
/*  86 */       _v_.unmarshal(_os_);
/*  87 */       this.ranklist.add(_v_);
/*     */     }
/*  89 */     this.inittime = _os_.unmarshal_long();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     for (xbean.LadderRankRole _v_ : this.ranklist)
/*     */     {
/* 100 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/* 102 */     _size_ += CodedOutputStream.computeInt64Size(2, this.inittime);
/* 103 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 112 */       for (xbean.LadderRankRole _v_ : this.ranklist)
/*     */       {
/* 114 */         _output_.writeMessage(1, _v_);
/*     */       }
/* 116 */       _output_.writeInt64(2, this.inittime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 120 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 122 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       boolean done = false;
/* 132 */       while (!done)
/*     */       {
/* 134 */         int tag = _input_.readTag();
/* 135 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 139 */           done = true;
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 144 */           xbean.LadderRankRole _v_ = new LadderRankRole(0, this, "ranklist");
/* 145 */           _input_.readMessage(_v_);
/* 146 */           this.ranklist.add(_v_);
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 151 */           this.inittime = _input_.readInt64();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 156 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 158 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 167 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 171 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 173 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LadderRank copy()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new LadderRank(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LadderRank toData()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LadderRank toBean()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new LadderRank(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.LadderRank toDataIf()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.LadderRank toBeanIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.LadderRankRole> getRanklist()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return xdb.Logs.logList(new LogKey(this, "ranklist"), this.ranklist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.LadderRankRole> getRanklistAsData()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/*     */     
/* 229 */     LadderRank _o_ = this;
/* 230 */     List<xbean.LadderRankRole> ranklist = new LinkedList();
/* 231 */     for (xbean.LadderRankRole _v_ : _o_.ranklist)
/* 232 */       ranklist.add(new LadderRankRole.Data(_v_));
/* 233 */     return ranklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getInittime()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.inittime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setInittime(long _v_)
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     xdb.Logs.logIf(new LogKey(this, "inittime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 253 */         new xdb.logs.LogLong(this, LadderRank.this.inittime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 257 */             LadderRank.this.inittime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 261 */     });
/* 262 */     this.inittime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     LadderRank _o_ = null;
/* 270 */     if ((_o1_ instanceof LadderRank)) { _o_ = (LadderRank)_o1_;
/* 271 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 272 */       return false;
/* 273 */     if (!this.ranklist.equals(_o_.ranklist)) return false;
/* 274 */     if (this.inittime != _o_.inittime) return false;
/* 275 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     int _h_ = 0;
/* 283 */     _h_ += this.ranklist.hashCode();
/* 284 */     _h_ = (int)(_h_ + this.inittime);
/* 285 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 291 */     _xdb_verify_unsafe_();
/* 292 */     StringBuilder _sb_ = new StringBuilder();
/* 293 */     _sb_.append("(");
/* 294 */     _sb_.append(this.ranklist);
/* 295 */     _sb_.append(",");
/* 296 */     _sb_.append(this.inittime);
/* 297 */     _sb_.append(")");
/* 298 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 304 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 305 */     lb.add(new xdb.logs.ListenableChanged().setVarName("ranklist"));
/* 306 */     lb.add(new xdb.logs.ListenableChanged().setVarName("inittime"));
/* 307 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.LadderRank {
/*     */     private Const() {}
/*     */     
/*     */     LadderRank nThis() {
/* 314 */       return LadderRank.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 320 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LadderRank copy()
/*     */     {
/* 326 */       return LadderRank.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LadderRank toData()
/*     */     {
/* 332 */       return LadderRank.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.LadderRank toBean()
/*     */     {
/* 337 */       return LadderRank.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LadderRank toDataIf()
/*     */     {
/* 343 */       return LadderRank.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.LadderRank toBeanIf()
/*     */     {
/* 348 */       return LadderRank.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.LadderRankRole> getRanklist()
/*     */     {
/* 355 */       LadderRank.this._xdb_verify_unsafe_();
/* 356 */       return xdb.Consts.constList(LadderRank.this.ranklist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.LadderRankRole> getRanklistAsData()
/*     */     {
/* 362 */       LadderRank.this._xdb_verify_unsafe_();
/*     */       
/* 364 */       LadderRank _o_ = LadderRank.this;
/* 365 */       List<xbean.LadderRankRole> ranklist = new LinkedList();
/* 366 */       for (xbean.LadderRankRole _v_ : _o_.ranklist)
/* 367 */         ranklist.add(new LadderRankRole.Data(_v_));
/* 368 */       return ranklist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getInittime()
/*     */     {
/* 375 */       LadderRank.this._xdb_verify_unsafe_();
/* 376 */       return LadderRank.this.inittime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInittime(long _v_)
/*     */     {
/* 383 */       LadderRank.this._xdb_verify_unsafe_();
/* 384 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 390 */       LadderRank.this._xdb_verify_unsafe_();
/* 391 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 397 */       LadderRank.this._xdb_verify_unsafe_();
/* 398 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 404 */       return LadderRank.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 410 */       return LadderRank.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 416 */       LadderRank.this._xdb_verify_unsafe_();
/* 417 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 423 */       return LadderRank.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 429 */       return LadderRank.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 435 */       LadderRank.this._xdb_verify_unsafe_();
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 442 */       return LadderRank.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 448 */       return LadderRank.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 454 */       return LadderRank.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 460 */       return LadderRank.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 466 */       return LadderRank.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 472 */       return LadderRank.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 478 */       return LadderRank.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.LadderRank
/*     */   {
/*     */     private LinkedList<xbean.LadderRankRole> ranklist;
/*     */     
/*     */     private long inittime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 492 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 497 */       this.ranklist = new LinkedList();
/*     */     }
/*     */     
/*     */     Data(xbean.LadderRank _o1_)
/*     */     {
/* 502 */       if ((_o1_ instanceof LadderRank)) { assign((LadderRank)_o1_);
/* 503 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 504 */       } else if ((_o1_ instanceof LadderRank.Const)) assign(((LadderRank.Const)_o1_).nThis()); else {
/* 505 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(LadderRank _o_) {
/* 510 */       this.ranklist = new LinkedList();
/* 511 */       for (xbean.LadderRankRole _v_ : _o_.ranklist)
/* 512 */         this.ranklist.add(new LadderRankRole.Data(_v_));
/* 513 */       this.inittime = _o_.inittime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 518 */       this.ranklist = new LinkedList();
/* 519 */       for (xbean.LadderRankRole _v_ : _o_.ranklist)
/* 520 */         this.ranklist.add(new LadderRankRole.Data(_v_));
/* 521 */       this.inittime = _o_.inittime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 527 */       _os_.compact_uint32(this.ranklist.size());
/* 528 */       for (xbean.LadderRankRole _v_ : this.ranklist)
/*     */       {
/* 530 */         _v_.marshal(_os_);
/*     */       }
/* 532 */       _os_.marshal(this.inittime);
/* 533 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 539 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 541 */         xbean.LadderRankRole _v_ = xbean.Pod.newLadderRankRoleData();
/* 542 */         _v_.unmarshal(_os_);
/* 543 */         this.ranklist.add(_v_);
/*     */       }
/* 545 */       this.inittime = _os_.unmarshal_long();
/* 546 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 552 */       int _size_ = 0;
/* 553 */       for (xbean.LadderRankRole _v_ : this.ranklist)
/*     */       {
/* 555 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 557 */       _size_ += CodedOutputStream.computeInt64Size(2, this.inittime);
/* 558 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 566 */         for (xbean.LadderRankRole _v_ : this.ranklist)
/*     */         {
/* 568 */           _output_.writeMessage(1, _v_);
/*     */         }
/* 570 */         _output_.writeInt64(2, this.inittime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 574 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 576 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 584 */         boolean done = false;
/* 585 */         while (!done)
/*     */         {
/* 587 */           int tag = _input_.readTag();
/* 588 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 592 */             done = true;
/* 593 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 597 */             xbean.LadderRankRole _v_ = xbean.Pod.newLadderRankRoleData();
/* 598 */             _input_.readMessage(_v_);
/* 599 */             this.ranklist.add(_v_);
/* 600 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 604 */             this.inittime = _input_.readInt64();
/* 605 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 609 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 611 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 620 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 624 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 626 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LadderRank copy()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LadderRank toData()
/*     */     {
/* 638 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.LadderRank toBean()
/*     */     {
/* 643 */       return new LadderRank(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.LadderRank toDataIf()
/*     */     {
/* 649 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.LadderRank toBeanIf()
/*     */     {
/* 654 */       return new LadderRank(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 660 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 664 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 668 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 672 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 676 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 680 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 684 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.LadderRankRole> getRanklist()
/*     */     {
/* 691 */       return this.ranklist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.LadderRankRole> getRanklistAsData()
/*     */     {
/* 698 */       return this.ranklist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getInittime()
/*     */     {
/* 705 */       return this.inittime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setInittime(long _v_)
/*     */     {
/* 712 */       this.inittime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 718 */       if (!(_o1_ instanceof Data)) return false;
/* 719 */       Data _o_ = (Data)_o1_;
/* 720 */       if (!this.ranklist.equals(_o_.ranklist)) return false;
/* 721 */       if (this.inittime != _o_.inittime) return false;
/* 722 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 728 */       int _h_ = 0;
/* 729 */       _h_ += this.ranklist.hashCode();
/* 730 */       _h_ = (int)(_h_ + this.inittime);
/* 731 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 737 */       StringBuilder _sb_ = new StringBuilder();
/* 738 */       _sb_.append("(");
/* 739 */       _sb_.append(this.ranklist);
/* 740 */       _sb_.append(",");
/* 741 */       _sb_.append(this.inittime);
/* 742 */       _sb_.append(")");
/* 743 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\LadderRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */