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
/*     */ public final class HomelandRankList extends XBean implements xbean.HomelandRankList
/*     */ {
/*     */   private LinkedList<Long> ranklist;
/*     */   private long awardtime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.ranklist.clear();
/*  21 */     this.awardtime = 0L;
/*     */   }
/*     */   
/*     */   HomelandRankList(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.ranklist = new LinkedList();
/*     */   }
/*     */   
/*     */   public HomelandRankList()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public HomelandRankList(HomelandRankList _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   HomelandRankList(xbean.HomelandRankList _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof HomelandRankList)) { assign((HomelandRankList)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(HomelandRankList _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.ranklist = new LinkedList();
/*  53 */     this.ranklist.addAll(_o_.ranklist);
/*  54 */     this.awardtime = _o_.awardtime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.ranklist = new LinkedList();
/*  60 */     this.ranklist.addAll(_o_.ranklist);
/*  61 */     this.awardtime = _o_.awardtime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _xdb_verify_unsafe_();
/*  68 */     _os_.compact_uint32(this.ranklist.size());
/*  69 */     for (Long _v_ : this.ranklist)
/*     */     {
/*  71 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  73 */     _os_.marshal(this.awardtime);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  83 */       long _v_ = 0L;
/*  84 */       _v_ = _os_.unmarshal_long();
/*  85 */       this.ranklist.add(Long.valueOf(_v_));
/*     */     }
/*  87 */     this.awardtime = _os_.unmarshal_long();
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*  95 */     int _size_ = 0;
/*  96 */     for (Long _v_ : this.ranklist)
/*     */     {
/*  98 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */     }
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(2, this.awardtime);
/* 101 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 110 */       for (Long _v_ : this.ranklist)
/*     */       {
/* 112 */         _output_.writeInt64(1, _v_.longValue());
/*     */       }
/* 114 */       _output_.writeInt64(2, this.awardtime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 118 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 120 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       boolean done = false;
/* 130 */       while (!done)
/*     */       {
/* 132 */         int tag = _input_.readTag();
/* 133 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 137 */           done = true;
/* 138 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 142 */           long _v_ = 0L;
/* 143 */           _v_ = _input_.readInt64();
/* 144 */           this.ranklist.add(Long.valueOf(_v_));
/* 145 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 149 */           this.awardtime = _input_.readInt64();
/* 150 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 154 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 156 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 165 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 169 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 171 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HomelandRankList copy()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new HomelandRankList(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HomelandRankList toData()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.HomelandRankList toBean()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new HomelandRankList(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.HomelandRankList toDataIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.HomelandRankList toBeanIf()
/*     */   {
/* 203 */     _xdb_verify_unsafe_();
/* 204 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 210 */     _xdb_verify_unsafe_();
/* 211 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getRanklist()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return xdb.Logs.logList(new LogKey(this, "ranklist"), this.ranklist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getRanklistAsData()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/*     */     
/* 227 */     HomelandRankList _o_ = this;
/* 228 */     List<Long> ranklist = new LinkedList();
/* 229 */     ranklist.addAll(_o_.ranklist);
/* 230 */     return ranklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getAwardtime()
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     return this.awardtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAwardtime(long _v_)
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     xdb.Logs.logIf(new LogKey(this, "awardtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 250 */         new xdb.logs.LogLong(this, HomelandRankList.this.awardtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 254 */             HomelandRankList.this.awardtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 258 */     });
/* 259 */     this.awardtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     HomelandRankList _o_ = null;
/* 267 */     if ((_o1_ instanceof HomelandRankList)) { _o_ = (HomelandRankList)_o1_;
/* 268 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 269 */       return false;
/* 270 */     if (!this.ranklist.equals(_o_.ranklist)) return false;
/* 271 */     if (this.awardtime != _o_.awardtime) return false;
/* 272 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     int _h_ = 0;
/* 280 */     _h_ += this.ranklist.hashCode();
/* 281 */     _h_ = (int)(_h_ + this.awardtime);
/* 282 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     StringBuilder _sb_ = new StringBuilder();
/* 290 */     _sb_.append("(");
/* 291 */     _sb_.append(this.ranklist);
/* 292 */     _sb_.append(",");
/* 293 */     _sb_.append(this.awardtime);
/* 294 */     _sb_.append(")");
/* 295 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 301 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 302 */     lb.add(new xdb.logs.ListenableChanged().setVarName("ranklist"));
/* 303 */     lb.add(new xdb.logs.ListenableChanged().setVarName("awardtime"));
/* 304 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.HomelandRankList {
/*     */     private Const() {}
/*     */     
/*     */     HomelandRankList nThis() {
/* 311 */       return HomelandRankList.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 317 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HomelandRankList copy()
/*     */     {
/* 323 */       return HomelandRankList.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HomelandRankList toData()
/*     */     {
/* 329 */       return HomelandRankList.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.HomelandRankList toBean()
/*     */     {
/* 334 */       return HomelandRankList.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HomelandRankList toDataIf()
/*     */     {
/* 340 */       return HomelandRankList.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.HomelandRankList toBeanIf()
/*     */     {
/* 345 */       return HomelandRankList.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRanklist()
/*     */     {
/* 352 */       HomelandRankList.this._xdb_verify_unsafe_();
/* 353 */       return xdb.Consts.constList(HomelandRankList.this.ranklist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getRanklistAsData()
/*     */     {
/* 359 */       HomelandRankList.this._xdb_verify_unsafe_();
/*     */       
/* 361 */       HomelandRankList _o_ = HomelandRankList.this;
/* 362 */       List<Long> ranklist = new LinkedList();
/* 363 */       ranklist.addAll(_o_.ranklist);
/* 364 */       return ranklist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAwardtime()
/*     */     {
/* 371 */       HomelandRankList.this._xdb_verify_unsafe_();
/* 372 */       return HomelandRankList.this.awardtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwardtime(long _v_)
/*     */     {
/* 379 */       HomelandRankList.this._xdb_verify_unsafe_();
/* 380 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 386 */       HomelandRankList.this._xdb_verify_unsafe_();
/* 387 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 393 */       HomelandRankList.this._xdb_verify_unsafe_();
/* 394 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 400 */       return HomelandRankList.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 406 */       return HomelandRankList.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 412 */       HomelandRankList.this._xdb_verify_unsafe_();
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 419 */       return HomelandRankList.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 425 */       return HomelandRankList.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 431 */       HomelandRankList.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 438 */       return HomelandRankList.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 444 */       return HomelandRankList.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 450 */       return HomelandRankList.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 456 */       return HomelandRankList.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 462 */       return HomelandRankList.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 468 */       return HomelandRankList.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 474 */       return HomelandRankList.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.HomelandRankList
/*     */   {
/*     */     private LinkedList<Long> ranklist;
/*     */     
/*     */     private long awardtime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 488 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 493 */       this.ranklist = new LinkedList();
/*     */     }
/*     */     
/*     */     Data(xbean.HomelandRankList _o1_)
/*     */     {
/* 498 */       if ((_o1_ instanceof HomelandRankList)) { assign((HomelandRankList)_o1_);
/* 499 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 500 */       } else if ((_o1_ instanceof HomelandRankList.Const)) assign(((HomelandRankList.Const)_o1_).nThis()); else {
/* 501 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(HomelandRankList _o_) {
/* 506 */       this.ranklist = new LinkedList();
/* 507 */       this.ranklist.addAll(_o_.ranklist);
/* 508 */       this.awardtime = _o_.awardtime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 513 */       this.ranklist = new LinkedList();
/* 514 */       this.ranklist.addAll(_o_.ranklist);
/* 515 */       this.awardtime = _o_.awardtime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       _os_.compact_uint32(this.ranklist.size());
/* 522 */       for (Long _v_ : this.ranklist)
/*     */       {
/* 524 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 526 */       _os_.marshal(this.awardtime);
/* 527 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 533 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 535 */         long _v_ = 0L;
/* 536 */         _v_ = _os_.unmarshal_long();
/* 537 */         this.ranklist.add(Long.valueOf(_v_));
/*     */       }
/* 539 */       this.awardtime = _os_.unmarshal_long();
/* 540 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 546 */       int _size_ = 0;
/* 547 */       for (Long _v_ : this.ranklist)
/*     */       {
/* 549 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */       }
/* 551 */       _size_ += CodedOutputStream.computeInt64Size(2, this.awardtime);
/* 552 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 560 */         for (Long _v_ : this.ranklist)
/*     */         {
/* 562 */           _output_.writeInt64(1, _v_.longValue());
/*     */         }
/* 564 */         _output_.writeInt64(2, this.awardtime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 568 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 570 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 578 */         boolean done = false;
/* 579 */         while (!done)
/*     */         {
/* 581 */           int tag = _input_.readTag();
/* 582 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 586 */             done = true;
/* 587 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 591 */             long _v_ = 0L;
/* 592 */             _v_ = _input_.readInt64();
/* 593 */             this.ranklist.add(Long.valueOf(_v_));
/* 594 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 598 */             this.awardtime = _input_.readInt64();
/* 599 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 603 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 605 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 614 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 618 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 620 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HomelandRankList copy()
/*     */     {
/* 626 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HomelandRankList toData()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.HomelandRankList toBean()
/*     */     {
/* 637 */       return new HomelandRankList(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.HomelandRankList toDataIf()
/*     */     {
/* 643 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.HomelandRankList toBeanIf()
/*     */     {
/* 648 */       return new HomelandRankList(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 654 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 658 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 662 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 666 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 670 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 674 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 678 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRanklist()
/*     */     {
/* 685 */       return this.ranklist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRanklistAsData()
/*     */     {
/* 692 */       return this.ranklist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAwardtime()
/*     */     {
/* 699 */       return this.awardtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwardtime(long _v_)
/*     */     {
/* 706 */       this.awardtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 712 */       if (!(_o1_ instanceof Data)) return false;
/* 713 */       Data _o_ = (Data)_o1_;
/* 714 */       if (!this.ranklist.equals(_o_.ranklist)) return false;
/* 715 */       if (this.awardtime != _o_.awardtime) return false;
/* 716 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 722 */       int _h_ = 0;
/* 723 */       _h_ += this.ranklist.hashCode();
/* 724 */       _h_ = (int)(_h_ + this.awardtime);
/* 725 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 731 */       StringBuilder _sb_ = new StringBuilder();
/* 732 */       _sb_.append("(");
/* 733 */       _sb_.append(this.ranklist);
/* 734 */       _sb_.append(",");
/* 735 */       _sb_.append(this.awardtime);
/* 736 */       _sb_.append(")");
/* 737 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\HomelandRankList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */