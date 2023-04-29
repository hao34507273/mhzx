/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class FactionMakeUpRecord extends XBean implements xbean.FactionMakeUpRecord
/*      */ {
/*      */   private int rightnum;
/*      */   private LinkedList<Long> joinroleids;
/*      */   private int questionid;
/*      */   private int curturn;
/*      */   private ArrayList<Integer> historyquestions;
/*      */   private ArrayList<Integer> optionids;
/*      */   private long starttime;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.rightnum = 0;
/*   31 */     this.joinroleids.clear();
/*   32 */     this.questionid = 0;
/*   33 */     this.curturn = 0;
/*   34 */     this.historyquestions.clear();
/*   35 */     this.optionids.clear();
/*   36 */     this.starttime = 0L;
/*      */   }
/*      */   
/*      */   FactionMakeUpRecord(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.joinroleids = new LinkedList();
/*   43 */     this.historyquestions = new ArrayList();
/*   44 */     this.optionids = new ArrayList();
/*      */   }
/*      */   
/*      */   public FactionMakeUpRecord()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public FactionMakeUpRecord(FactionMakeUpRecord _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   FactionMakeUpRecord(xbean.FactionMakeUpRecord _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof FactionMakeUpRecord)) { assign((FactionMakeUpRecord)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(FactionMakeUpRecord _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.rightnum = _o_.rightnum;
/*   70 */     this.joinroleids = new LinkedList();
/*   71 */     this.joinroleids.addAll(_o_.joinroleids);
/*   72 */     this.questionid = _o_.questionid;
/*   73 */     this.curturn = _o_.curturn;
/*   74 */     this.historyquestions = new ArrayList();
/*   75 */     this.historyquestions.addAll(_o_.historyquestions);
/*   76 */     this.optionids = new ArrayList();
/*   77 */     this.optionids.addAll(_o_.optionids);
/*   78 */     this.starttime = _o_.starttime;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   83 */     this.rightnum = _o_.rightnum;
/*   84 */     this.joinroleids = new LinkedList();
/*   85 */     this.joinroleids.addAll(_o_.joinroleids);
/*   86 */     this.questionid = _o_.questionid;
/*   87 */     this.curturn = _o_.curturn;
/*   88 */     this.historyquestions = new ArrayList();
/*   89 */     this.historyquestions.addAll(_o_.historyquestions);
/*   90 */     this.optionids = new ArrayList();
/*   91 */     this.optionids.addAll(_o_.optionids);
/*   92 */     this.starttime = _o_.starttime;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   98 */     _xdb_verify_unsafe_();
/*   99 */     _os_.marshal(this.rightnum);
/*  100 */     _os_.compact_uint32(this.joinroleids.size());
/*  101 */     for (Long _v_ : this.joinroleids)
/*      */     {
/*  103 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  105 */     _os_.marshal(this.questionid);
/*  106 */     _os_.marshal(this.curturn);
/*  107 */     _os_.compact_uint32(this.historyquestions.size());
/*  108 */     for (Integer _v_ : this.historyquestions)
/*      */     {
/*  110 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  112 */     _os_.compact_uint32(this.optionids.size());
/*  113 */     for (Integer _v_ : this.optionids)
/*      */     {
/*  115 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  117 */     _os_.marshal(this.starttime);
/*  118 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*  125 */     this.rightnum = _os_.unmarshal_int();
/*  126 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  128 */       long _v_ = 0L;
/*  129 */       _v_ = _os_.unmarshal_long();
/*  130 */       this.joinroleids.add(Long.valueOf(_v_));
/*      */     }
/*  132 */     this.questionid = _os_.unmarshal_int();
/*  133 */     this.curturn = _os_.unmarshal_int();
/*  134 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  136 */       int _v_ = 0;
/*  137 */       _v_ = _os_.unmarshal_int();
/*  138 */       this.historyquestions.add(Integer.valueOf(_v_));
/*      */     }
/*  140 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  142 */       int _v_ = 0;
/*  143 */       _v_ = _os_.unmarshal_int();
/*  144 */       this.optionids.add(Integer.valueOf(_v_));
/*      */     }
/*  146 */     this.starttime = _os_.unmarshal_long();
/*  147 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  153 */     _xdb_verify_unsafe_();
/*  154 */     int _size_ = 0;
/*  155 */     _size_ += CodedOutputStream.computeInt32Size(1, this.rightnum);
/*  156 */     for (Long _v_ : this.joinroleids)
/*      */     {
/*  158 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */     }
/*  160 */     _size_ += CodedOutputStream.computeInt32Size(3, this.questionid);
/*  161 */     _size_ += CodedOutputStream.computeInt32Size(4, this.curturn);
/*  162 */     for (Integer _v_ : this.historyquestions)
/*      */     {
/*  164 */       _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */     }
/*  166 */     for (Integer _v_ : this.optionids)
/*      */     {
/*  168 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  170 */     _size_ += CodedOutputStream.computeInt64Size(7, this.starttime);
/*  171 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  177 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  180 */       _output_.writeInt32(1, this.rightnum);
/*  181 */       for (Long _v_ : this.joinroleids)
/*      */       {
/*  183 */         _output_.writeInt64(2, _v_.longValue());
/*      */       }
/*  185 */       _output_.writeInt32(3, this.questionid);
/*  186 */       _output_.writeInt32(4, this.curturn);
/*  187 */       for (Integer _v_ : this.historyquestions)
/*      */       {
/*  189 */         _output_.writeInt32(5, _v_.intValue());
/*      */       }
/*  191 */       for (Integer _v_ : this.optionids)
/*      */       {
/*  193 */         _output_.writeInt32(6, _v_.intValue());
/*      */       }
/*  195 */       _output_.writeInt64(7, this.starttime);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  199 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  201 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  207 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  210 */       boolean done = false;
/*  211 */       while (!done)
/*      */       {
/*  213 */         int tag = _input_.readTag();
/*  214 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  218 */           done = true;
/*  219 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  223 */           this.rightnum = _input_.readInt32();
/*  224 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  228 */           long _v_ = 0L;
/*  229 */           _v_ = _input_.readInt64();
/*  230 */           this.joinroleids.add(Long.valueOf(_v_));
/*  231 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  235 */           this.questionid = _input_.readInt32();
/*  236 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  240 */           this.curturn = _input_.readInt32();
/*  241 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  245 */           int _v_ = 0;
/*  246 */           _v_ = _input_.readInt32();
/*  247 */           this.historyquestions.add(Integer.valueOf(_v_));
/*  248 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  252 */           int _v_ = 0;
/*  253 */           _v_ = _input_.readInt32();
/*  254 */           this.optionids.add(Integer.valueOf(_v_));
/*  255 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  259 */           this.starttime = _input_.readInt64();
/*  260 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  264 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  266 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  275 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  279 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  281 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FactionMakeUpRecord copy()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return new FactionMakeUpRecord(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FactionMakeUpRecord toData()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FactionMakeUpRecord toBean()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return new FactionMakeUpRecord(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FactionMakeUpRecord toDataIf()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FactionMakeUpRecord toBeanIf()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*  314 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRightnum()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return this.rightnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getJoinroleids()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     return Logs.logList(new LogKey(this, "joinroleids"), this.joinroleids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getJoinroleidsAsData()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*      */     
/*  345 */     FactionMakeUpRecord _o_ = this;
/*  346 */     List<Long> joinroleids = new LinkedList();
/*  347 */     joinroleids.addAll(_o_.joinroleids);
/*  348 */     return joinroleids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getQuestionid()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     return this.questionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurturn()
/*      */   {
/*  363 */     _xdb_verify_unsafe_();
/*  364 */     return this.curturn;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getHistoryquestions()
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     return Logs.logList(new LogKey(this, "historyquestions"), this.historyquestions);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getHistoryquestionsAsData()
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*      */     
/*  380 */     FactionMakeUpRecord _o_ = this;
/*  381 */     List<Integer> historyquestions = new ArrayList();
/*  382 */     historyquestions.addAll(_o_.historyquestions);
/*  383 */     return historyquestions;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getOptionids()
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*  391 */     return Logs.logList(new LogKey(this, "optionids"), this.optionids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getOptionidsAsData()
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*      */     
/*  399 */     FactionMakeUpRecord _o_ = this;
/*  400 */     List<Integer> optionids = new ArrayList();
/*  401 */     optionids.addAll(_o_.optionids);
/*  402 */     return optionids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStarttime()
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     return this.starttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRightnum(int _v_)
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     Logs.logIf(new LogKey(this, "rightnum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  422 */         new LogInt(this, FactionMakeUpRecord.this.rightnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  426 */             FactionMakeUpRecord.this.rightnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  430 */     });
/*  431 */     this.rightnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setQuestionid(int _v_)
/*      */   {
/*  438 */     _xdb_verify_unsafe_();
/*  439 */     Logs.logIf(new LogKey(this, "questionid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  443 */         new LogInt(this, FactionMakeUpRecord.this.questionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  447 */             FactionMakeUpRecord.this.questionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  451 */     });
/*  452 */     this.questionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurturn(int _v_)
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     Logs.logIf(new LogKey(this, "curturn")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  464 */         new LogInt(this, FactionMakeUpRecord.this.curturn)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  468 */             FactionMakeUpRecord.this.curturn = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  472 */     });
/*  473 */     this.curturn = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStarttime(long _v_)
/*      */   {
/*  480 */     _xdb_verify_unsafe_();
/*  481 */     Logs.logIf(new LogKey(this, "starttime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  485 */         new xdb.logs.LogLong(this, FactionMakeUpRecord.this.starttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  489 */             FactionMakeUpRecord.this.starttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  493 */     });
/*  494 */     this.starttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  500 */     _xdb_verify_unsafe_();
/*  501 */     FactionMakeUpRecord _o_ = null;
/*  502 */     if ((_o1_ instanceof FactionMakeUpRecord)) { _o_ = (FactionMakeUpRecord)_o1_;
/*  503 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  504 */       return false;
/*  505 */     if (this.rightnum != _o_.rightnum) return false;
/*  506 */     if (!this.joinroleids.equals(_o_.joinroleids)) return false;
/*  507 */     if (this.questionid != _o_.questionid) return false;
/*  508 */     if (this.curturn != _o_.curturn) return false;
/*  509 */     if (!this.historyquestions.equals(_o_.historyquestions)) return false;
/*  510 */     if (!this.optionids.equals(_o_.optionids)) return false;
/*  511 */     if (this.starttime != _o_.starttime) return false;
/*  512 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  518 */     _xdb_verify_unsafe_();
/*  519 */     int _h_ = 0;
/*  520 */     _h_ += this.rightnum;
/*  521 */     _h_ += this.joinroleids.hashCode();
/*  522 */     _h_ += this.questionid;
/*  523 */     _h_ += this.curturn;
/*  524 */     _h_ += this.historyquestions.hashCode();
/*  525 */     _h_ += this.optionids.hashCode();
/*  526 */     _h_ = (int)(_h_ + this.starttime);
/*  527 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  533 */     _xdb_verify_unsafe_();
/*  534 */     StringBuilder _sb_ = new StringBuilder();
/*  535 */     _sb_.append("(");
/*  536 */     _sb_.append(this.rightnum);
/*  537 */     _sb_.append(",");
/*  538 */     _sb_.append(this.joinroleids);
/*  539 */     _sb_.append(",");
/*  540 */     _sb_.append(this.questionid);
/*  541 */     _sb_.append(",");
/*  542 */     _sb_.append(this.curturn);
/*  543 */     _sb_.append(",");
/*  544 */     _sb_.append(this.historyquestions);
/*  545 */     _sb_.append(",");
/*  546 */     _sb_.append(this.optionids);
/*  547 */     _sb_.append(",");
/*  548 */     _sb_.append(this.starttime);
/*  549 */     _sb_.append(")");
/*  550 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  556 */     ListenableBean lb = new ListenableBean();
/*  557 */     lb.add(new ListenableChanged().setVarName("rightnum"));
/*  558 */     lb.add(new ListenableChanged().setVarName("joinroleids"));
/*  559 */     lb.add(new ListenableChanged().setVarName("questionid"));
/*  560 */     lb.add(new ListenableChanged().setVarName("curturn"));
/*  561 */     lb.add(new ListenableChanged().setVarName("historyquestions"));
/*  562 */     lb.add(new ListenableChanged().setVarName("optionids"));
/*  563 */     lb.add(new ListenableChanged().setVarName("starttime"));
/*  564 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.FactionMakeUpRecord {
/*      */     private Const() {}
/*      */     
/*      */     FactionMakeUpRecord nThis() {
/*  571 */       return FactionMakeUpRecord.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  577 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionMakeUpRecord copy()
/*      */     {
/*  583 */       return FactionMakeUpRecord.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionMakeUpRecord toData()
/*      */     {
/*  589 */       return FactionMakeUpRecord.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.FactionMakeUpRecord toBean()
/*      */     {
/*  594 */       return FactionMakeUpRecord.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionMakeUpRecord toDataIf()
/*      */     {
/*  600 */       return FactionMakeUpRecord.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.FactionMakeUpRecord toBeanIf()
/*      */     {
/*  605 */       return FactionMakeUpRecord.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRightnum()
/*      */     {
/*  612 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  613 */       return FactionMakeUpRecord.this.rightnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getJoinroleids()
/*      */     {
/*  620 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  621 */       return xdb.Consts.constList(FactionMakeUpRecord.this.joinroleids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getJoinroleidsAsData()
/*      */     {
/*  627 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*      */       
/*  629 */       FactionMakeUpRecord _o_ = FactionMakeUpRecord.this;
/*  630 */       List<Long> joinroleids = new LinkedList();
/*  631 */       joinroleids.addAll(_o_.joinroleids);
/*  632 */       return joinroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getQuestionid()
/*      */     {
/*  639 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  640 */       return FactionMakeUpRecord.this.questionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurturn()
/*      */     {
/*  647 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  648 */       return FactionMakeUpRecord.this.curturn;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getHistoryquestions()
/*      */     {
/*  655 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  656 */       return xdb.Consts.constList(FactionMakeUpRecord.this.historyquestions);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getHistoryquestionsAsData()
/*      */     {
/*  662 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*      */       
/*  664 */       FactionMakeUpRecord _o_ = FactionMakeUpRecord.this;
/*  665 */       List<Integer> historyquestions = new ArrayList();
/*  666 */       historyquestions.addAll(_o_.historyquestions);
/*  667 */       return historyquestions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getOptionids()
/*      */     {
/*  674 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  675 */       return xdb.Consts.constList(FactionMakeUpRecord.this.optionids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getOptionidsAsData()
/*      */     {
/*  681 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*      */       
/*  683 */       FactionMakeUpRecord _o_ = FactionMakeUpRecord.this;
/*  684 */       List<Integer> optionids = new ArrayList();
/*  685 */       optionids.addAll(_o_.optionids);
/*  686 */       return optionids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/*  693 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  694 */       return FactionMakeUpRecord.this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRightnum(int _v_)
/*      */     {
/*  701 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  702 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setQuestionid(int _v_)
/*      */     {
/*  709 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  710 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurturn(int _v_)
/*      */     {
/*  717 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  718 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/*  725 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  726 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  732 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  733 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  739 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  740 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  746 */       return FactionMakeUpRecord.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  752 */       return FactionMakeUpRecord.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  758 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  759 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  765 */       return FactionMakeUpRecord.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  771 */       return FactionMakeUpRecord.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  777 */       FactionMakeUpRecord.this._xdb_verify_unsafe_();
/*  778 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  784 */       return FactionMakeUpRecord.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  790 */       return FactionMakeUpRecord.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  796 */       return FactionMakeUpRecord.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  802 */       return FactionMakeUpRecord.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  808 */       return FactionMakeUpRecord.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  814 */       return FactionMakeUpRecord.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  820 */       return FactionMakeUpRecord.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.FactionMakeUpRecord
/*      */   {
/*      */     private int rightnum;
/*      */     
/*      */     private LinkedList<Long> joinroleids;
/*      */     
/*      */     private int questionid;
/*      */     
/*      */     private int curturn;
/*      */     
/*      */     private ArrayList<Integer> historyquestions;
/*      */     
/*      */     private ArrayList<Integer> optionids;
/*      */     
/*      */     private long starttime;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  844 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  849 */       this.joinroleids = new LinkedList();
/*  850 */       this.historyquestions = new ArrayList();
/*  851 */       this.optionids = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.FactionMakeUpRecord _o1_)
/*      */     {
/*  856 */       if ((_o1_ instanceof FactionMakeUpRecord)) { assign((FactionMakeUpRecord)_o1_);
/*  857 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  858 */       } else if ((_o1_ instanceof FactionMakeUpRecord.Const)) assign(((FactionMakeUpRecord.Const)_o1_).nThis()); else {
/*  859 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(FactionMakeUpRecord _o_) {
/*  864 */       this.rightnum = _o_.rightnum;
/*  865 */       this.joinroleids = new LinkedList();
/*  866 */       this.joinroleids.addAll(_o_.joinroleids);
/*  867 */       this.questionid = _o_.questionid;
/*  868 */       this.curturn = _o_.curturn;
/*  869 */       this.historyquestions = new ArrayList();
/*  870 */       this.historyquestions.addAll(_o_.historyquestions);
/*  871 */       this.optionids = new ArrayList();
/*  872 */       this.optionids.addAll(_o_.optionids);
/*  873 */       this.starttime = _o_.starttime;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  878 */       this.rightnum = _o_.rightnum;
/*  879 */       this.joinroleids = new LinkedList();
/*  880 */       this.joinroleids.addAll(_o_.joinroleids);
/*  881 */       this.questionid = _o_.questionid;
/*  882 */       this.curturn = _o_.curturn;
/*  883 */       this.historyquestions = new ArrayList();
/*  884 */       this.historyquestions.addAll(_o_.historyquestions);
/*  885 */       this.optionids = new ArrayList();
/*  886 */       this.optionids.addAll(_o_.optionids);
/*  887 */       this.starttime = _o_.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  893 */       _os_.marshal(this.rightnum);
/*  894 */       _os_.compact_uint32(this.joinroleids.size());
/*  895 */       for (Long _v_ : this.joinroleids)
/*      */       {
/*  897 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  899 */       _os_.marshal(this.questionid);
/*  900 */       _os_.marshal(this.curturn);
/*  901 */       _os_.compact_uint32(this.historyquestions.size());
/*  902 */       for (Integer _v_ : this.historyquestions)
/*      */       {
/*  904 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  906 */       _os_.compact_uint32(this.optionids.size());
/*  907 */       for (Integer _v_ : this.optionids)
/*      */       {
/*  909 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  911 */       _os_.marshal(this.starttime);
/*  912 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  918 */       this.rightnum = _os_.unmarshal_int();
/*  919 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  921 */         long _v_ = 0L;
/*  922 */         _v_ = _os_.unmarshal_long();
/*  923 */         this.joinroleids.add(Long.valueOf(_v_));
/*      */       }
/*  925 */       this.questionid = _os_.unmarshal_int();
/*  926 */       this.curturn = _os_.unmarshal_int();
/*  927 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  929 */         int _v_ = 0;
/*  930 */         _v_ = _os_.unmarshal_int();
/*  931 */         this.historyquestions.add(Integer.valueOf(_v_));
/*      */       }
/*  933 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  935 */         int _v_ = 0;
/*  936 */         _v_ = _os_.unmarshal_int();
/*  937 */         this.optionids.add(Integer.valueOf(_v_));
/*      */       }
/*  939 */       this.starttime = _os_.unmarshal_long();
/*  940 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  946 */       int _size_ = 0;
/*  947 */       _size_ += CodedOutputStream.computeInt32Size(1, this.rightnum);
/*  948 */       for (Long _v_ : this.joinroleids)
/*      */       {
/*  950 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */       }
/*  952 */       _size_ += CodedOutputStream.computeInt32Size(3, this.questionid);
/*  953 */       _size_ += CodedOutputStream.computeInt32Size(4, this.curturn);
/*  954 */       for (Integer _v_ : this.historyquestions)
/*      */       {
/*  956 */         _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */       }
/*  958 */       for (Integer _v_ : this.optionids)
/*      */       {
/*  960 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/*  962 */       _size_ += CodedOutputStream.computeInt64Size(7, this.starttime);
/*  963 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  971 */         _output_.writeInt32(1, this.rightnum);
/*  972 */         for (Long _v_ : this.joinroleids)
/*      */         {
/*  974 */           _output_.writeInt64(2, _v_.longValue());
/*      */         }
/*  976 */         _output_.writeInt32(3, this.questionid);
/*  977 */         _output_.writeInt32(4, this.curturn);
/*  978 */         for (Integer _v_ : this.historyquestions)
/*      */         {
/*  980 */           _output_.writeInt32(5, _v_.intValue());
/*      */         }
/*  982 */         for (Integer _v_ : this.optionids)
/*      */         {
/*  984 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/*  986 */         _output_.writeInt64(7, this.starttime);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  990 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  992 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1000 */         boolean done = false;
/* 1001 */         while (!done)
/*      */         {
/* 1003 */           int tag = _input_.readTag();
/* 1004 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1008 */             done = true;
/* 1009 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1013 */             this.rightnum = _input_.readInt32();
/* 1014 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1018 */             long _v_ = 0L;
/* 1019 */             _v_ = _input_.readInt64();
/* 1020 */             this.joinroleids.add(Long.valueOf(_v_));
/* 1021 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1025 */             this.questionid = _input_.readInt32();
/* 1026 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1030 */             this.curturn = _input_.readInt32();
/* 1031 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1035 */             int _v_ = 0;
/* 1036 */             _v_ = _input_.readInt32();
/* 1037 */             this.historyquestions.add(Integer.valueOf(_v_));
/* 1038 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1042 */             int _v_ = 0;
/* 1043 */             _v_ = _input_.readInt32();
/* 1044 */             this.optionids.add(Integer.valueOf(_v_));
/* 1045 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1049 */             this.starttime = _input_.readInt64();
/* 1050 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1054 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1056 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1065 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1069 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1071 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionMakeUpRecord copy()
/*      */     {
/* 1077 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionMakeUpRecord toData()
/*      */     {
/* 1083 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.FactionMakeUpRecord toBean()
/*      */     {
/* 1088 */       return new FactionMakeUpRecord(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionMakeUpRecord toDataIf()
/*      */     {
/* 1094 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.FactionMakeUpRecord toBeanIf()
/*      */     {
/* 1099 */       return new FactionMakeUpRecord(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1105 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1109 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1113 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1117 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1121 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1125 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1129 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRightnum()
/*      */     {
/* 1136 */       return this.rightnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getJoinroleids()
/*      */     {
/* 1143 */       return this.joinroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getJoinroleidsAsData()
/*      */     {
/* 1150 */       return this.joinroleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getQuestionid()
/*      */     {
/* 1157 */       return this.questionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurturn()
/*      */     {
/* 1164 */       return this.curturn;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getHistoryquestions()
/*      */     {
/* 1171 */       return this.historyquestions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getHistoryquestionsAsData()
/*      */     {
/* 1178 */       return this.historyquestions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getOptionids()
/*      */     {
/* 1185 */       return this.optionids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getOptionidsAsData()
/*      */     {
/* 1192 */       return this.optionids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/* 1199 */       return this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRightnum(int _v_)
/*      */     {
/* 1206 */       this.rightnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setQuestionid(int _v_)
/*      */     {
/* 1213 */       this.questionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurturn(int _v_)
/*      */     {
/* 1220 */       this.curturn = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/* 1227 */       this.starttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1233 */       if (!(_o1_ instanceof Data)) return false;
/* 1234 */       Data _o_ = (Data)_o1_;
/* 1235 */       if (this.rightnum != _o_.rightnum) return false;
/* 1236 */       if (!this.joinroleids.equals(_o_.joinroleids)) return false;
/* 1237 */       if (this.questionid != _o_.questionid) return false;
/* 1238 */       if (this.curturn != _o_.curturn) return false;
/* 1239 */       if (!this.historyquestions.equals(_o_.historyquestions)) return false;
/* 1240 */       if (!this.optionids.equals(_o_.optionids)) return false;
/* 1241 */       if (this.starttime != _o_.starttime) return false;
/* 1242 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1248 */       int _h_ = 0;
/* 1249 */       _h_ += this.rightnum;
/* 1250 */       _h_ += this.joinroleids.hashCode();
/* 1251 */       _h_ += this.questionid;
/* 1252 */       _h_ += this.curturn;
/* 1253 */       _h_ += this.historyquestions.hashCode();
/* 1254 */       _h_ += this.optionids.hashCode();
/* 1255 */       _h_ = (int)(_h_ + this.starttime);
/* 1256 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1262 */       StringBuilder _sb_ = new StringBuilder();
/* 1263 */       _sb_.append("(");
/* 1264 */       _sb_.append(this.rightnum);
/* 1265 */       _sb_.append(",");
/* 1266 */       _sb_.append(this.joinroleids);
/* 1267 */       _sb_.append(",");
/* 1268 */       _sb_.append(this.questionid);
/* 1269 */       _sb_.append(",");
/* 1270 */       _sb_.append(this.curturn);
/* 1271 */       _sb_.append(",");
/* 1272 */       _sb_.append(this.historyquestions);
/* 1273 */       _sb_.append(",");
/* 1274 */       _sb_.append(this.optionids);
/* 1275 */       _sb_.append(",");
/* 1276 */       _sb_.append(this.starttime);
/* 1277 */       _sb_.append(")");
/* 1278 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FactionMakeUpRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */