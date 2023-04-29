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
/*     */ public final class CoupleQuestionInfo extends XBean implements xbean.CoupleQuestionInfo
/*     */ {
/*     */   private LinkedList<Integer> questionlist;
/*     */   private int currentquestionidx;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.questionlist.clear();
/*  21 */     this.currentquestionidx = 0;
/*     */   }
/*     */   
/*     */   CoupleQuestionInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.questionlist = new LinkedList();
/*     */   }
/*     */   
/*     */   public CoupleQuestionInfo()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CoupleQuestionInfo(CoupleQuestionInfo _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CoupleQuestionInfo(xbean.CoupleQuestionInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof CoupleQuestionInfo)) { assign((CoupleQuestionInfo)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CoupleQuestionInfo _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.questionlist = new LinkedList();
/*  53 */     this.questionlist.addAll(_o_.questionlist);
/*  54 */     this.currentquestionidx = _o_.currentquestionidx;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.questionlist = new LinkedList();
/*  60 */     this.questionlist.addAll(_o_.questionlist);
/*  61 */     this.currentquestionidx = _o_.currentquestionidx;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _xdb_verify_unsafe_();
/*  68 */     _os_.compact_uint32(this.questionlist.size());
/*  69 */     for (Integer _v_ : this.questionlist)
/*     */     {
/*  71 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  73 */     _os_.marshal(this.currentquestionidx);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  83 */       int _v_ = 0;
/*  84 */       _v_ = _os_.unmarshal_int();
/*  85 */       this.questionlist.add(Integer.valueOf(_v_));
/*     */     }
/*  87 */     this.currentquestionidx = _os_.unmarshal_int();
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*  95 */     int _size_ = 0;
/*  96 */     for (Integer _v_ : this.questionlist)
/*     */     {
/*  98 */       _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */     }
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(2, this.currentquestionidx);
/* 101 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 110 */       for (Integer _v_ : this.questionlist)
/*     */       {
/* 112 */         _output_.writeInt32(1, _v_.intValue());
/*     */       }
/* 114 */       _output_.writeInt32(2, this.currentquestionidx);
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
/* 142 */           int _v_ = 0;
/* 143 */           _v_ = _input_.readInt32();
/* 144 */           this.questionlist.add(Integer.valueOf(_v_));
/* 145 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 149 */           this.currentquestionidx = _input_.readInt32();
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
/*     */   public xbean.CoupleQuestionInfo copy()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new CoupleQuestionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CoupleQuestionInfo toData()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CoupleQuestionInfo toBean()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new CoupleQuestionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CoupleQuestionInfo toDataIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CoupleQuestionInfo toBeanIf()
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
/*     */   public List<Integer> getQuestionlist()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return xdb.Logs.logList(new LogKey(this, "questionlist"), this.questionlist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getQuestionlistAsData()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/*     */     
/* 227 */     CoupleQuestionInfo _o_ = this;
/* 228 */     List<Integer> questionlist = new LinkedList();
/* 229 */     questionlist.addAll(_o_.questionlist);
/* 230 */     return questionlist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCurrentquestionidx()
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     return this.currentquestionidx;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCurrentquestionidx(int _v_)
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     xdb.Logs.logIf(new LogKey(this, "currentquestionidx")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 250 */         new xdb.logs.LogInt(this, CoupleQuestionInfo.this.currentquestionidx)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 254 */             CoupleQuestionInfo.this.currentquestionidx = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 258 */     });
/* 259 */     this.currentquestionidx = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     CoupleQuestionInfo _o_ = null;
/* 267 */     if ((_o1_ instanceof CoupleQuestionInfo)) { _o_ = (CoupleQuestionInfo)_o1_;
/* 268 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 269 */       return false;
/* 270 */     if (!this.questionlist.equals(_o_.questionlist)) return false;
/* 271 */     if (this.currentquestionidx != _o_.currentquestionidx) return false;
/* 272 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     int _h_ = 0;
/* 280 */     _h_ += this.questionlist.hashCode();
/* 281 */     _h_ += this.currentquestionidx;
/* 282 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     StringBuilder _sb_ = new StringBuilder();
/* 290 */     _sb_.append("(");
/* 291 */     _sb_.append(this.questionlist);
/* 292 */     _sb_.append(",");
/* 293 */     _sb_.append(this.currentquestionidx);
/* 294 */     _sb_.append(")");
/* 295 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 301 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 302 */     lb.add(new xdb.logs.ListenableChanged().setVarName("questionlist"));
/* 303 */     lb.add(new xdb.logs.ListenableChanged().setVarName("currentquestionidx"));
/* 304 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CoupleQuestionInfo {
/*     */     private Const() {}
/*     */     
/*     */     CoupleQuestionInfo nThis() {
/* 311 */       return CoupleQuestionInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 317 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CoupleQuestionInfo copy()
/*     */     {
/* 323 */       return CoupleQuestionInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CoupleQuestionInfo toData()
/*     */     {
/* 329 */       return CoupleQuestionInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CoupleQuestionInfo toBean()
/*     */     {
/* 334 */       return CoupleQuestionInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CoupleQuestionInfo toDataIf()
/*     */     {
/* 340 */       return CoupleQuestionInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CoupleQuestionInfo toBeanIf()
/*     */     {
/* 345 */       return CoupleQuestionInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getQuestionlist()
/*     */     {
/* 352 */       CoupleQuestionInfo.this._xdb_verify_unsafe_();
/* 353 */       return xdb.Consts.constList(CoupleQuestionInfo.this.questionlist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getQuestionlistAsData()
/*     */     {
/* 359 */       CoupleQuestionInfo.this._xdb_verify_unsafe_();
/*     */       
/* 361 */       CoupleQuestionInfo _o_ = CoupleQuestionInfo.this;
/* 362 */       List<Integer> questionlist = new LinkedList();
/* 363 */       questionlist.addAll(_o_.questionlist);
/* 364 */       return questionlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurrentquestionidx()
/*     */     {
/* 371 */       CoupleQuestionInfo.this._xdb_verify_unsafe_();
/* 372 */       return CoupleQuestionInfo.this.currentquestionidx;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurrentquestionidx(int _v_)
/*     */     {
/* 379 */       CoupleQuestionInfo.this._xdb_verify_unsafe_();
/* 380 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 386 */       CoupleQuestionInfo.this._xdb_verify_unsafe_();
/* 387 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 393 */       CoupleQuestionInfo.this._xdb_verify_unsafe_();
/* 394 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 400 */       return CoupleQuestionInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 406 */       return CoupleQuestionInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 412 */       CoupleQuestionInfo.this._xdb_verify_unsafe_();
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 419 */       return CoupleQuestionInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 425 */       return CoupleQuestionInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 431 */       CoupleQuestionInfo.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 438 */       return CoupleQuestionInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 444 */       return CoupleQuestionInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 450 */       return CoupleQuestionInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 456 */       return CoupleQuestionInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 462 */       return CoupleQuestionInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 468 */       return CoupleQuestionInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 474 */       return CoupleQuestionInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CoupleQuestionInfo
/*     */   {
/*     */     private LinkedList<Integer> questionlist;
/*     */     
/*     */     private int currentquestionidx;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 488 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 493 */       this.questionlist = new LinkedList();
/*     */     }
/*     */     
/*     */     Data(xbean.CoupleQuestionInfo _o1_)
/*     */     {
/* 498 */       if ((_o1_ instanceof CoupleQuestionInfo)) { assign((CoupleQuestionInfo)_o1_);
/* 499 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 500 */       } else if ((_o1_ instanceof CoupleQuestionInfo.Const)) assign(((CoupleQuestionInfo.Const)_o1_).nThis()); else {
/* 501 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CoupleQuestionInfo _o_) {
/* 506 */       this.questionlist = new LinkedList();
/* 507 */       this.questionlist.addAll(_o_.questionlist);
/* 508 */       this.currentquestionidx = _o_.currentquestionidx;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 513 */       this.questionlist = new LinkedList();
/* 514 */       this.questionlist.addAll(_o_.questionlist);
/* 515 */       this.currentquestionidx = _o_.currentquestionidx;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       _os_.compact_uint32(this.questionlist.size());
/* 522 */       for (Integer _v_ : this.questionlist)
/*     */       {
/* 524 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 526 */       _os_.marshal(this.currentquestionidx);
/* 527 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 533 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 535 */         int _v_ = 0;
/* 536 */         _v_ = _os_.unmarshal_int();
/* 537 */         this.questionlist.add(Integer.valueOf(_v_));
/*     */       }
/* 539 */       this.currentquestionidx = _os_.unmarshal_int();
/* 540 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 546 */       int _size_ = 0;
/* 547 */       for (Integer _v_ : this.questionlist)
/*     */       {
/* 549 */         _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */       }
/* 551 */       _size_ += CodedOutputStream.computeInt32Size(2, this.currentquestionidx);
/* 552 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 560 */         for (Integer _v_ : this.questionlist)
/*     */         {
/* 562 */           _output_.writeInt32(1, _v_.intValue());
/*     */         }
/* 564 */         _output_.writeInt32(2, this.currentquestionidx);
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
/* 591 */             int _v_ = 0;
/* 592 */             _v_ = _input_.readInt32();
/* 593 */             this.questionlist.add(Integer.valueOf(_v_));
/* 594 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 598 */             this.currentquestionidx = _input_.readInt32();
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
/*     */     public xbean.CoupleQuestionInfo copy()
/*     */     {
/* 626 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CoupleQuestionInfo toData()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CoupleQuestionInfo toBean()
/*     */     {
/* 637 */       return new CoupleQuestionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CoupleQuestionInfo toDataIf()
/*     */     {
/* 643 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CoupleQuestionInfo toBeanIf()
/*     */     {
/* 648 */       return new CoupleQuestionInfo(this, null, null);
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
/*     */     public List<Integer> getQuestionlist()
/*     */     {
/* 685 */       return this.questionlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getQuestionlistAsData()
/*     */     {
/* 692 */       return this.questionlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurrentquestionidx()
/*     */     {
/* 699 */       return this.currentquestionidx;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurrentquestionidx(int _v_)
/*     */     {
/* 706 */       this.currentquestionidx = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 712 */       if (!(_o1_ instanceof Data)) return false;
/* 713 */       Data _o_ = (Data)_o1_;
/* 714 */       if (!this.questionlist.equals(_o_.questionlist)) return false;
/* 715 */       if (this.currentquestionidx != _o_.currentquestionidx) return false;
/* 716 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 722 */       int _h_ = 0;
/* 723 */       _h_ += this.questionlist.hashCode();
/* 724 */       _h_ += this.currentquestionidx;
/* 725 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 731 */       StringBuilder _sb_ = new StringBuilder();
/* 732 */       _sb_.append("(");
/* 733 */       _sb_.append(this.questionlist);
/* 734 */       _sb_.append(",");
/* 735 */       _sb_.append(this.currentquestionidx);
/* 736 */       _sb_.append(")");
/* 737 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CoupleQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */