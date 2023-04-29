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
/*     */ 
/*     */ public final class SeasonMultiTaskInfo extends XBean implements xbean.SeasonMultiTaskInfo
/*     */ {
/*     */   private int step;
/*     */   private ArrayList<Integer> finishsteps;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.step = 0;
/*  21 */     this.finishsteps.clear();
/*     */   }
/*     */   
/*     */   SeasonMultiTaskInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.finishsteps = new ArrayList();
/*     */   }
/*     */   
/*     */   public SeasonMultiTaskInfo()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SeasonMultiTaskInfo(SeasonMultiTaskInfo _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SeasonMultiTaskInfo(xbean.SeasonMultiTaskInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof SeasonMultiTaskInfo)) { assign((SeasonMultiTaskInfo)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SeasonMultiTaskInfo _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.step = _o_.step;
/*  53 */     this.finishsteps = new ArrayList();
/*  54 */     this.finishsteps.addAll(_o_.finishsteps);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.step = _o_.step;
/*  60 */     this.finishsteps = new ArrayList();
/*  61 */     this.finishsteps.addAll(_o_.finishsteps);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _xdb_verify_unsafe_();
/*  68 */     _os_.marshal(this.step);
/*  69 */     _os_.compact_uint32(this.finishsteps.size());
/*  70 */     for (Integer _v_ : this.finishsteps)
/*     */     {
/*  72 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.step = _os_.unmarshal_int();
/*  82 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  84 */       int _v_ = 0;
/*  85 */       _v_ = _os_.unmarshal_int();
/*  86 */       this.finishsteps.add(Integer.valueOf(_v_));
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*  95 */     int _size_ = 0;
/*  96 */     _size_ += CodedOutputStream.computeInt32Size(1, this.step);
/*  97 */     for (Integer _v_ : this.finishsteps)
/*     */     {
/*  99 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */     }
/* 101 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 110 */       _output_.writeInt32(1, this.step);
/* 111 */       for (Integer _v_ : this.finishsteps)
/*     */       {
/* 113 */         _output_.writeInt32(2, _v_.intValue());
/*     */       }
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
/* 142 */           this.step = _input_.readInt32();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           int _v_ = 0;
/* 148 */           _v_ = _input_.readInt32();
/* 149 */           this.finishsteps.add(Integer.valueOf(_v_));
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
/*     */   public xbean.SeasonMultiTaskInfo copy()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new SeasonMultiTaskInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SeasonMultiTaskInfo toData()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SeasonMultiTaskInfo toBean()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new SeasonMultiTaskInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SeasonMultiTaskInfo toDataIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SeasonMultiTaskInfo toBeanIf()
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
/*     */   public int getStep()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return this.step;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getFinishsteps()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return xdb.Logs.logList(new LogKey(this, "finishsteps"), this.finishsteps);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getFinishstepsAsData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/*     */     
/* 235 */     SeasonMultiTaskInfo _o_ = this;
/* 236 */     List<Integer> finishsteps = new ArrayList();
/* 237 */     finishsteps.addAll(_o_.finishsteps);
/* 238 */     return finishsteps;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStep(int _v_)
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     xdb.Logs.logIf(new LogKey(this, "step")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 250 */         new xdb.logs.LogInt(this, SeasonMultiTaskInfo.this.step)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 254 */             SeasonMultiTaskInfo.this.step = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 258 */     });
/* 259 */     this.step = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     SeasonMultiTaskInfo _o_ = null;
/* 267 */     if ((_o1_ instanceof SeasonMultiTaskInfo)) { _o_ = (SeasonMultiTaskInfo)_o1_;
/* 268 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 269 */       return false;
/* 270 */     if (this.step != _o_.step) return false;
/* 271 */     if (!this.finishsteps.equals(_o_.finishsteps)) return false;
/* 272 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     int _h_ = 0;
/* 280 */     _h_ += this.step;
/* 281 */     _h_ += this.finishsteps.hashCode();
/* 282 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     StringBuilder _sb_ = new StringBuilder();
/* 290 */     _sb_.append("(");
/* 291 */     _sb_.append(this.step);
/* 292 */     _sb_.append(",");
/* 293 */     _sb_.append(this.finishsteps);
/* 294 */     _sb_.append(")");
/* 295 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 301 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 302 */     lb.add(new xdb.logs.ListenableChanged().setVarName("step"));
/* 303 */     lb.add(new xdb.logs.ListenableChanged().setVarName("finishsteps"));
/* 304 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SeasonMultiTaskInfo {
/*     */     private Const() {}
/*     */     
/*     */     SeasonMultiTaskInfo nThis() {
/* 311 */       return SeasonMultiTaskInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 317 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SeasonMultiTaskInfo copy()
/*     */     {
/* 323 */       return SeasonMultiTaskInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SeasonMultiTaskInfo toData()
/*     */     {
/* 329 */       return SeasonMultiTaskInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SeasonMultiTaskInfo toBean()
/*     */     {
/* 334 */       return SeasonMultiTaskInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SeasonMultiTaskInfo toDataIf()
/*     */     {
/* 340 */       return SeasonMultiTaskInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SeasonMultiTaskInfo toBeanIf()
/*     */     {
/* 345 */       return SeasonMultiTaskInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStep()
/*     */     {
/* 352 */       SeasonMultiTaskInfo.this._xdb_verify_unsafe_();
/* 353 */       return SeasonMultiTaskInfo.this.step;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getFinishsteps()
/*     */     {
/* 360 */       SeasonMultiTaskInfo.this._xdb_verify_unsafe_();
/* 361 */       return xdb.Consts.constList(SeasonMultiTaskInfo.this.finishsteps);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getFinishstepsAsData()
/*     */     {
/* 367 */       SeasonMultiTaskInfo.this._xdb_verify_unsafe_();
/*     */       
/* 369 */       SeasonMultiTaskInfo _o_ = SeasonMultiTaskInfo.this;
/* 370 */       List<Integer> finishsteps = new ArrayList();
/* 371 */       finishsteps.addAll(_o_.finishsteps);
/* 372 */       return finishsteps;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStep(int _v_)
/*     */     {
/* 379 */       SeasonMultiTaskInfo.this._xdb_verify_unsafe_();
/* 380 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 386 */       SeasonMultiTaskInfo.this._xdb_verify_unsafe_();
/* 387 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 393 */       SeasonMultiTaskInfo.this._xdb_verify_unsafe_();
/* 394 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 400 */       return SeasonMultiTaskInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 406 */       return SeasonMultiTaskInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 412 */       SeasonMultiTaskInfo.this._xdb_verify_unsafe_();
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 419 */       return SeasonMultiTaskInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 425 */       return SeasonMultiTaskInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 431 */       SeasonMultiTaskInfo.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 438 */       return SeasonMultiTaskInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 444 */       return SeasonMultiTaskInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 450 */       return SeasonMultiTaskInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 456 */       return SeasonMultiTaskInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 462 */       return SeasonMultiTaskInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 468 */       return SeasonMultiTaskInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 474 */       return SeasonMultiTaskInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SeasonMultiTaskInfo
/*     */   {
/*     */     private int step;
/*     */     
/*     */     private ArrayList<Integer> finishsteps;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 488 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 493 */       this.finishsteps = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.SeasonMultiTaskInfo _o1_)
/*     */     {
/* 498 */       if ((_o1_ instanceof SeasonMultiTaskInfo)) { assign((SeasonMultiTaskInfo)_o1_);
/* 499 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 500 */       } else if ((_o1_ instanceof SeasonMultiTaskInfo.Const)) assign(((SeasonMultiTaskInfo.Const)_o1_).nThis()); else {
/* 501 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SeasonMultiTaskInfo _o_) {
/* 506 */       this.step = _o_.step;
/* 507 */       this.finishsteps = new ArrayList();
/* 508 */       this.finishsteps.addAll(_o_.finishsteps);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 513 */       this.step = _o_.step;
/* 514 */       this.finishsteps = new ArrayList();
/* 515 */       this.finishsteps.addAll(_o_.finishsteps);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       _os_.marshal(this.step);
/* 522 */       _os_.compact_uint32(this.finishsteps.size());
/* 523 */       for (Integer _v_ : this.finishsteps)
/*     */       {
/* 525 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 527 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 533 */       this.step = _os_.unmarshal_int();
/* 534 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 536 */         int _v_ = 0;
/* 537 */         _v_ = _os_.unmarshal_int();
/* 538 */         this.finishsteps.add(Integer.valueOf(_v_));
/*     */       }
/* 540 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 546 */       int _size_ = 0;
/* 547 */       _size_ += CodedOutputStream.computeInt32Size(1, this.step);
/* 548 */       for (Integer _v_ : this.finishsteps)
/*     */       {
/* 550 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 552 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 560 */         _output_.writeInt32(1, this.step);
/* 561 */         for (Integer _v_ : this.finishsteps)
/*     */         {
/* 563 */           _output_.writeInt32(2, _v_.intValue());
/*     */         }
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
/* 591 */             this.step = _input_.readInt32();
/* 592 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 596 */             int _v_ = 0;
/* 597 */             _v_ = _input_.readInt32();
/* 598 */             this.finishsteps.add(Integer.valueOf(_v_));
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
/*     */     public xbean.SeasonMultiTaskInfo copy()
/*     */     {
/* 626 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SeasonMultiTaskInfo toData()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SeasonMultiTaskInfo toBean()
/*     */     {
/* 637 */       return new SeasonMultiTaskInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SeasonMultiTaskInfo toDataIf()
/*     */     {
/* 643 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SeasonMultiTaskInfo toBeanIf()
/*     */     {
/* 648 */       return new SeasonMultiTaskInfo(this, null, null);
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
/*     */     public int getStep()
/*     */     {
/* 685 */       return this.step;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getFinishsteps()
/*     */     {
/* 692 */       return this.finishsteps;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getFinishstepsAsData()
/*     */     {
/* 699 */       return this.finishsteps;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStep(int _v_)
/*     */     {
/* 706 */       this.step = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 712 */       if (!(_o1_ instanceof Data)) return false;
/* 713 */       Data _o_ = (Data)_o1_;
/* 714 */       if (this.step != _o_.step) return false;
/* 715 */       if (!this.finishsteps.equals(_o_.finishsteps)) return false;
/* 716 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 722 */       int _h_ = 0;
/* 723 */       _h_ += this.step;
/* 724 */       _h_ += this.finishsteps.hashCode();
/* 725 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 731 */       StringBuilder _sb_ = new StringBuilder();
/* 732 */       _sb_.append("(");
/* 733 */       _sb_.append(this.step);
/* 734 */       _sb_.append(",");
/* 735 */       _sb_.append(this.finishsteps);
/* 736 */       _sb_.append(")");
/* 737 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SeasonMultiTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */