/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class QYXTQuestionInfo extends XBean implements xbean.QYXTQuestionInfo
/*      */ {
/*      */   private int rightnum;
/*      */   private SetX<Integer> seek_help_questions;
/*      */   private SetX<Long> current_help_roleids;
/*      */   private ArrayList<Integer> questions;
/*      */   private int current_force_answer_index;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.rightnum = 0;
/*   27 */     this.seek_help_questions.clear();
/*   28 */     this.current_help_roleids.clear();
/*   29 */     this.questions.clear();
/*   30 */     this.current_force_answer_index = 0;
/*      */   }
/*      */   
/*      */   QYXTQuestionInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.seek_help_questions = new SetX();
/*   37 */     this.current_help_roleids = new SetX();
/*   38 */     this.questions = new ArrayList();
/*      */   }
/*      */   
/*      */   public QYXTQuestionInfo()
/*      */   {
/*   43 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public QYXTQuestionInfo(QYXTQuestionInfo _o_)
/*      */   {
/*   48 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   QYXTQuestionInfo(xbean.QYXTQuestionInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     if ((_o1_ instanceof QYXTQuestionInfo)) { assign((QYXTQuestionInfo)_o1_);
/*   55 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   56 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   57 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(QYXTQuestionInfo _o_) {
/*   62 */     _o_._xdb_verify_unsafe_();
/*   63 */     this.rightnum = _o_.rightnum;
/*   64 */     this.seek_help_questions = new SetX();
/*   65 */     this.seek_help_questions.addAll(_o_.seek_help_questions);
/*   66 */     this.current_help_roleids = new SetX();
/*   67 */     this.current_help_roleids.addAll(_o_.current_help_roleids);
/*   68 */     this.questions = new ArrayList();
/*   69 */     this.questions.addAll(_o_.questions);
/*   70 */     this.current_force_answer_index = _o_.current_force_answer_index;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   75 */     this.rightnum = _o_.rightnum;
/*   76 */     this.seek_help_questions = new SetX();
/*   77 */     this.seek_help_questions.addAll(_o_.seek_help_questions);
/*   78 */     this.current_help_roleids = new SetX();
/*   79 */     this.current_help_roleids.addAll(_o_.current_help_roleids);
/*   80 */     this.questions = new ArrayList();
/*   81 */     this.questions.addAll(_o_.questions);
/*   82 */     this.current_force_answer_index = _o_.current_force_answer_index;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   88 */     _xdb_verify_unsafe_();
/*   89 */     _os_.marshal(this.rightnum);
/*   90 */     _os_.compact_uint32(this.seek_help_questions.size());
/*   91 */     for (Integer _v_ : this.seek_help_questions)
/*      */     {
/*   93 */       _os_.marshal(_v_.intValue());
/*      */     }
/*   95 */     _os_.compact_uint32(this.current_help_roleids.size());
/*   96 */     for (Long _v_ : this.current_help_roleids)
/*      */     {
/*   98 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  100 */     _os_.compact_uint32(this.questions.size());
/*  101 */     for (Integer _v_ : this.questions)
/*      */     {
/*  103 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  105 */     _os_.marshal(this.current_force_answer_index);
/*  106 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*  113 */     this.rightnum = _os_.unmarshal_int();
/*  114 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  116 */       int _v_ = 0;
/*  117 */       _v_ = _os_.unmarshal_int();
/*  118 */       this.seek_help_questions.add(Integer.valueOf(_v_));
/*      */     }
/*  120 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  122 */       long _v_ = 0L;
/*  123 */       _v_ = _os_.unmarshal_long();
/*  124 */       this.current_help_roleids.add(Long.valueOf(_v_));
/*      */     }
/*  126 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  128 */       int _v_ = 0;
/*  129 */       _v_ = _os_.unmarshal_int();
/*  130 */       this.questions.add(Integer.valueOf(_v_));
/*      */     }
/*  132 */     this.current_force_answer_index = _os_.unmarshal_int();
/*  133 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  139 */     _xdb_verify_unsafe_();
/*  140 */     int _size_ = 0;
/*  141 */     _size_ += CodedOutputStream.computeInt32Size(1, this.rightnum);
/*  142 */     for (Integer _v_ : this.seek_help_questions)
/*      */     {
/*  144 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */     }
/*  146 */     for (Long _v_ : this.current_help_roleids)
/*      */     {
/*  148 */       _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */     }
/*  150 */     for (Integer _v_ : this.questions)
/*      */     {
/*  152 */       _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */     }
/*  154 */     _size_ += CodedOutputStream.computeInt32Size(5, this.current_force_answer_index);
/*  155 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  161 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  164 */       _output_.writeInt32(1, this.rightnum);
/*  165 */       for (Integer _v_ : this.seek_help_questions)
/*      */       {
/*  167 */         _output_.writeInt32(2, _v_.intValue());
/*      */       }
/*  169 */       for (Long _v_ : this.current_help_roleids)
/*      */       {
/*  171 */         _output_.writeInt64(3, _v_.longValue());
/*      */       }
/*  173 */       for (Integer _v_ : this.questions)
/*      */       {
/*  175 */         _output_.writeInt32(4, _v_.intValue());
/*      */       }
/*  177 */       _output_.writeInt32(5, this.current_force_answer_index);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  181 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  183 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  189 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  192 */       boolean done = false;
/*  193 */       while (!done)
/*      */       {
/*  195 */         int tag = _input_.readTag();
/*  196 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  200 */           done = true;
/*  201 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  205 */           this.rightnum = _input_.readInt32();
/*  206 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  210 */           int _v_ = 0;
/*  211 */           _v_ = _input_.readInt32();
/*  212 */           this.seek_help_questions.add(Integer.valueOf(_v_));
/*  213 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  217 */           long _v_ = 0L;
/*  218 */           _v_ = _input_.readInt64();
/*  219 */           this.current_help_roleids.add(Long.valueOf(_v_));
/*  220 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  224 */           int _v_ = 0;
/*  225 */           _v_ = _input_.readInt32();
/*  226 */           this.questions.add(Integer.valueOf(_v_));
/*  227 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  231 */           this.current_force_answer_index = _input_.readInt32();
/*  232 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  236 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  238 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  247 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  251 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  253 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.QYXTQuestionInfo copy()
/*      */   {
/*  259 */     _xdb_verify_unsafe_();
/*  260 */     return new QYXTQuestionInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.QYXTQuestionInfo toData()
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*  267 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.QYXTQuestionInfo toBean()
/*      */   {
/*  272 */     _xdb_verify_unsafe_();
/*  273 */     return new QYXTQuestionInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.QYXTQuestionInfo toDataIf()
/*      */   {
/*  279 */     _xdb_verify_unsafe_();
/*  280 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.QYXTQuestionInfo toBeanIf()
/*      */   {
/*  285 */     _xdb_verify_unsafe_();
/*  286 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRightnum()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return this.rightnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getSeek_help_questions()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return xdb.Logs.logSet(new LogKey(this, "seek_help_questions"), this.seek_help_questions);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getSeek_help_questionsAsData()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*      */     
/*  317 */     QYXTQuestionInfo _o_ = this;
/*  318 */     Set<Integer> seek_help_questions = new SetX();
/*  319 */     seek_help_questions.addAll(_o_.seek_help_questions);
/*  320 */     return seek_help_questions;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getCurrent_help_roleids()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return xdb.Logs.logSet(new LogKey(this, "current_help_roleids"), this.current_help_roleids);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getCurrent_help_roleidsAsData()
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*      */     
/*  336 */     QYXTQuestionInfo _o_ = this;
/*  337 */     Set<Long> current_help_roleids = new SetX();
/*  338 */     current_help_roleids.addAll(_o_.current_help_roleids);
/*  339 */     return current_help_roleids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getQuestions()
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*  347 */     return xdb.Logs.logList(new LogKey(this, "questions"), this.questions);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getQuestionsAsData()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*      */     
/*  355 */     QYXTQuestionInfo _o_ = this;
/*  356 */     List<Integer> questions = new ArrayList();
/*  357 */     questions.addAll(_o_.questions);
/*  358 */     return questions;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_force_answer_index()
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     return this.current_force_answer_index;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRightnum(int _v_)
/*      */   {
/*  373 */     _xdb_verify_unsafe_();
/*  374 */     xdb.Logs.logIf(new LogKey(this, "rightnum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  378 */         new xdb.logs.LogInt(this, QYXTQuestionInfo.this.rightnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  382 */             QYXTQuestionInfo.this.rightnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  386 */     });
/*  387 */     this.rightnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_force_answer_index(int _v_)
/*      */   {
/*  394 */     _xdb_verify_unsafe_();
/*  395 */     xdb.Logs.logIf(new LogKey(this, "current_force_answer_index")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  399 */         new xdb.logs.LogInt(this, QYXTQuestionInfo.this.current_force_answer_index)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  403 */             QYXTQuestionInfo.this.current_force_answer_index = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  407 */     });
/*  408 */     this.current_force_answer_index = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*  415 */     QYXTQuestionInfo _o_ = null;
/*  416 */     if ((_o1_ instanceof QYXTQuestionInfo)) { _o_ = (QYXTQuestionInfo)_o1_;
/*  417 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  418 */       return false;
/*  419 */     if (this.rightnum != _o_.rightnum) return false;
/*  420 */     if (!this.seek_help_questions.equals(_o_.seek_help_questions)) return false;
/*  421 */     if (!this.current_help_roleids.equals(_o_.current_help_roleids)) return false;
/*  422 */     if (!this.questions.equals(_o_.questions)) return false;
/*  423 */     if (this.current_force_answer_index != _o_.current_force_answer_index) return false;
/*  424 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     int _h_ = 0;
/*  432 */     _h_ += this.rightnum;
/*  433 */     _h_ += this.seek_help_questions.hashCode();
/*  434 */     _h_ += this.current_help_roleids.hashCode();
/*  435 */     _h_ += this.questions.hashCode();
/*  436 */     _h_ += this.current_force_answer_index;
/*  437 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*  444 */     StringBuilder _sb_ = new StringBuilder();
/*  445 */     _sb_.append("(");
/*  446 */     _sb_.append(this.rightnum);
/*  447 */     _sb_.append(",");
/*  448 */     _sb_.append(this.seek_help_questions);
/*  449 */     _sb_.append(",");
/*  450 */     _sb_.append(this.current_help_roleids);
/*  451 */     _sb_.append(",");
/*  452 */     _sb_.append(this.questions);
/*  453 */     _sb_.append(",");
/*  454 */     _sb_.append(this.current_force_answer_index);
/*  455 */     _sb_.append(")");
/*  456 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  462 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  463 */     lb.add(new xdb.logs.ListenableChanged().setVarName("rightnum"));
/*  464 */     lb.add(new xdb.logs.ListenableSet().setVarName("seek_help_questions"));
/*  465 */     lb.add(new xdb.logs.ListenableSet().setVarName("current_help_roleids"));
/*  466 */     lb.add(new xdb.logs.ListenableChanged().setVarName("questions"));
/*  467 */     lb.add(new xdb.logs.ListenableChanged().setVarName("current_force_answer_index"));
/*  468 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.QYXTQuestionInfo {
/*      */     private Const() {}
/*      */     
/*      */     QYXTQuestionInfo nThis() {
/*  475 */       return QYXTQuestionInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  481 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QYXTQuestionInfo copy()
/*      */     {
/*  487 */       return QYXTQuestionInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QYXTQuestionInfo toData()
/*      */     {
/*  493 */       return QYXTQuestionInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.QYXTQuestionInfo toBean()
/*      */     {
/*  498 */       return QYXTQuestionInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QYXTQuestionInfo toDataIf()
/*      */     {
/*  504 */       return QYXTQuestionInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.QYXTQuestionInfo toBeanIf()
/*      */     {
/*  509 */       return QYXTQuestionInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRightnum()
/*      */     {
/*  516 */       QYXTQuestionInfo.this._xdb_verify_unsafe_();
/*  517 */       return QYXTQuestionInfo.this.rightnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSeek_help_questions()
/*      */     {
/*  524 */       QYXTQuestionInfo.this._xdb_verify_unsafe_();
/*  525 */       return xdb.Consts.constSet(QYXTQuestionInfo.this.seek_help_questions);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getSeek_help_questionsAsData()
/*      */     {
/*  531 */       QYXTQuestionInfo.this._xdb_verify_unsafe_();
/*      */       
/*  533 */       QYXTQuestionInfo _o_ = QYXTQuestionInfo.this;
/*  534 */       Set<Integer> seek_help_questions = new SetX();
/*  535 */       seek_help_questions.addAll(_o_.seek_help_questions);
/*  536 */       return seek_help_questions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCurrent_help_roleids()
/*      */     {
/*  543 */       QYXTQuestionInfo.this._xdb_verify_unsafe_();
/*  544 */       return xdb.Consts.constSet(QYXTQuestionInfo.this.current_help_roleids);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getCurrent_help_roleidsAsData()
/*      */     {
/*  550 */       QYXTQuestionInfo.this._xdb_verify_unsafe_();
/*      */       
/*  552 */       QYXTQuestionInfo _o_ = QYXTQuestionInfo.this;
/*  553 */       Set<Long> current_help_roleids = new SetX();
/*  554 */       current_help_roleids.addAll(_o_.current_help_roleids);
/*  555 */       return current_help_roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getQuestions()
/*      */     {
/*  562 */       QYXTQuestionInfo.this._xdb_verify_unsafe_();
/*  563 */       return xdb.Consts.constList(QYXTQuestionInfo.this.questions);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getQuestionsAsData()
/*      */     {
/*  569 */       QYXTQuestionInfo.this._xdb_verify_unsafe_();
/*      */       
/*  571 */       QYXTQuestionInfo _o_ = QYXTQuestionInfo.this;
/*  572 */       List<Integer> questions = new ArrayList();
/*  573 */       questions.addAll(_o_.questions);
/*  574 */       return questions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_force_answer_index()
/*      */     {
/*  581 */       QYXTQuestionInfo.this._xdb_verify_unsafe_();
/*  582 */       return QYXTQuestionInfo.this.current_force_answer_index;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRightnum(int _v_)
/*      */     {
/*  589 */       QYXTQuestionInfo.this._xdb_verify_unsafe_();
/*  590 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_force_answer_index(int _v_)
/*      */     {
/*  597 */       QYXTQuestionInfo.this._xdb_verify_unsafe_();
/*  598 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  604 */       QYXTQuestionInfo.this._xdb_verify_unsafe_();
/*  605 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  611 */       QYXTQuestionInfo.this._xdb_verify_unsafe_();
/*  612 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  618 */       return QYXTQuestionInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  624 */       return QYXTQuestionInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  630 */       QYXTQuestionInfo.this._xdb_verify_unsafe_();
/*  631 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  637 */       return QYXTQuestionInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  643 */       return QYXTQuestionInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  649 */       QYXTQuestionInfo.this._xdb_verify_unsafe_();
/*  650 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  656 */       return QYXTQuestionInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  662 */       return QYXTQuestionInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  668 */       return QYXTQuestionInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  674 */       return QYXTQuestionInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  680 */       return QYXTQuestionInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  686 */       return QYXTQuestionInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  692 */       return QYXTQuestionInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.QYXTQuestionInfo
/*      */   {
/*      */     private int rightnum;
/*      */     
/*      */     private HashSet<Integer> seek_help_questions;
/*      */     
/*      */     private HashSet<Long> current_help_roleids;
/*      */     
/*      */     private ArrayList<Integer> questions;
/*      */     
/*      */     private int current_force_answer_index;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  712 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  717 */       this.seek_help_questions = new HashSet();
/*  718 */       this.current_help_roleids = new HashSet();
/*  719 */       this.questions = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.QYXTQuestionInfo _o1_)
/*      */     {
/*  724 */       if ((_o1_ instanceof QYXTQuestionInfo)) { assign((QYXTQuestionInfo)_o1_);
/*  725 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  726 */       } else if ((_o1_ instanceof QYXTQuestionInfo.Const)) assign(((QYXTQuestionInfo.Const)_o1_).nThis()); else {
/*  727 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(QYXTQuestionInfo _o_) {
/*  732 */       this.rightnum = _o_.rightnum;
/*  733 */       this.seek_help_questions = new HashSet();
/*  734 */       this.seek_help_questions.addAll(_o_.seek_help_questions);
/*  735 */       this.current_help_roleids = new HashSet();
/*  736 */       this.current_help_roleids.addAll(_o_.current_help_roleids);
/*  737 */       this.questions = new ArrayList();
/*  738 */       this.questions.addAll(_o_.questions);
/*  739 */       this.current_force_answer_index = _o_.current_force_answer_index;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  744 */       this.rightnum = _o_.rightnum;
/*  745 */       this.seek_help_questions = new HashSet();
/*  746 */       this.seek_help_questions.addAll(_o_.seek_help_questions);
/*  747 */       this.current_help_roleids = new HashSet();
/*  748 */       this.current_help_roleids.addAll(_o_.current_help_roleids);
/*  749 */       this.questions = new ArrayList();
/*  750 */       this.questions.addAll(_o_.questions);
/*  751 */       this.current_force_answer_index = _o_.current_force_answer_index;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  757 */       _os_.marshal(this.rightnum);
/*  758 */       _os_.compact_uint32(this.seek_help_questions.size());
/*  759 */       for (Integer _v_ : this.seek_help_questions)
/*      */       {
/*  761 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  763 */       _os_.compact_uint32(this.current_help_roleids.size());
/*  764 */       for (Long _v_ : this.current_help_roleids)
/*      */       {
/*  766 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  768 */       _os_.compact_uint32(this.questions.size());
/*  769 */       for (Integer _v_ : this.questions)
/*      */       {
/*  771 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  773 */       _os_.marshal(this.current_force_answer_index);
/*  774 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  780 */       this.rightnum = _os_.unmarshal_int();
/*  781 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  783 */         int _v_ = 0;
/*  784 */         _v_ = _os_.unmarshal_int();
/*  785 */         this.seek_help_questions.add(Integer.valueOf(_v_));
/*      */       }
/*  787 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  789 */         long _v_ = 0L;
/*  790 */         _v_ = _os_.unmarshal_long();
/*  791 */         this.current_help_roleids.add(Long.valueOf(_v_));
/*      */       }
/*  793 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  795 */         int _v_ = 0;
/*  796 */         _v_ = _os_.unmarshal_int();
/*  797 */         this.questions.add(Integer.valueOf(_v_));
/*      */       }
/*  799 */       this.current_force_answer_index = _os_.unmarshal_int();
/*  800 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  806 */       int _size_ = 0;
/*  807 */       _size_ += CodedOutputStream.computeInt32Size(1, this.rightnum);
/*  808 */       for (Integer _v_ : this.seek_help_questions)
/*      */       {
/*  810 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */       }
/*  812 */       for (Long _v_ : this.current_help_roleids)
/*      */       {
/*  814 */         _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */       }
/*  816 */       for (Integer _v_ : this.questions)
/*      */       {
/*  818 */         _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */       }
/*  820 */       _size_ += CodedOutputStream.computeInt32Size(5, this.current_force_answer_index);
/*  821 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  829 */         _output_.writeInt32(1, this.rightnum);
/*  830 */         for (Integer _v_ : this.seek_help_questions)
/*      */         {
/*  832 */           _output_.writeInt32(2, _v_.intValue());
/*      */         }
/*  834 */         for (Long _v_ : this.current_help_roleids)
/*      */         {
/*  836 */           _output_.writeInt64(3, _v_.longValue());
/*      */         }
/*  838 */         for (Integer _v_ : this.questions)
/*      */         {
/*  840 */           _output_.writeInt32(4, _v_.intValue());
/*      */         }
/*  842 */         _output_.writeInt32(5, this.current_force_answer_index);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  846 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  848 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  856 */         boolean done = false;
/*  857 */         while (!done)
/*      */         {
/*  859 */           int tag = _input_.readTag();
/*  860 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  864 */             done = true;
/*  865 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  869 */             this.rightnum = _input_.readInt32();
/*  870 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  874 */             int _v_ = 0;
/*  875 */             _v_ = _input_.readInt32();
/*  876 */             this.seek_help_questions.add(Integer.valueOf(_v_));
/*  877 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  881 */             long _v_ = 0L;
/*  882 */             _v_ = _input_.readInt64();
/*  883 */             this.current_help_roleids.add(Long.valueOf(_v_));
/*  884 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  888 */             int _v_ = 0;
/*  889 */             _v_ = _input_.readInt32();
/*  890 */             this.questions.add(Integer.valueOf(_v_));
/*  891 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  895 */             this.current_force_answer_index = _input_.readInt32();
/*  896 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  900 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  902 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  911 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  915 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  917 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QYXTQuestionInfo copy()
/*      */     {
/*  923 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QYXTQuestionInfo toData()
/*      */     {
/*  929 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.QYXTQuestionInfo toBean()
/*      */     {
/*  934 */       return new QYXTQuestionInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QYXTQuestionInfo toDataIf()
/*      */     {
/*  940 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.QYXTQuestionInfo toBeanIf()
/*      */     {
/*  945 */       return new QYXTQuestionInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  951 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  955 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  959 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  963 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  967 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  971 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  975 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRightnum()
/*      */     {
/*  982 */       return this.rightnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSeek_help_questions()
/*      */     {
/*  989 */       return this.seek_help_questions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSeek_help_questionsAsData()
/*      */     {
/*  996 */       return this.seek_help_questions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCurrent_help_roleids()
/*      */     {
/* 1003 */       return this.current_help_roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCurrent_help_roleidsAsData()
/*      */     {
/* 1010 */       return this.current_help_roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getQuestions()
/*      */     {
/* 1017 */       return this.questions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getQuestionsAsData()
/*      */     {
/* 1024 */       return this.questions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_force_answer_index()
/*      */     {
/* 1031 */       return this.current_force_answer_index;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRightnum(int _v_)
/*      */     {
/* 1038 */       this.rightnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_force_answer_index(int _v_)
/*      */     {
/* 1045 */       this.current_force_answer_index = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1051 */       if (!(_o1_ instanceof Data)) return false;
/* 1052 */       Data _o_ = (Data)_o1_;
/* 1053 */       if (this.rightnum != _o_.rightnum) return false;
/* 1054 */       if (!this.seek_help_questions.equals(_o_.seek_help_questions)) return false;
/* 1055 */       if (!this.current_help_roleids.equals(_o_.current_help_roleids)) return false;
/* 1056 */       if (!this.questions.equals(_o_.questions)) return false;
/* 1057 */       if (this.current_force_answer_index != _o_.current_force_answer_index) return false;
/* 1058 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1064 */       int _h_ = 0;
/* 1065 */       _h_ += this.rightnum;
/* 1066 */       _h_ += this.seek_help_questions.hashCode();
/* 1067 */       _h_ += this.current_help_roleids.hashCode();
/* 1068 */       _h_ += this.questions.hashCode();
/* 1069 */       _h_ += this.current_force_answer_index;
/* 1070 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1076 */       StringBuilder _sb_ = new StringBuilder();
/* 1077 */       _sb_.append("(");
/* 1078 */       _sb_.append(this.rightnum);
/* 1079 */       _sb_.append(",");
/* 1080 */       _sb_.append(this.seek_help_questions);
/* 1081 */       _sb_.append(",");
/* 1082 */       _sb_.append(this.current_help_roleids);
/* 1083 */       _sb_.append(",");
/* 1084 */       _sb_.append(this.questions);
/* 1085 */       _sb_.append(",");
/* 1086 */       _sb_.append(this.current_force_answer_index);
/* 1087 */       _sb_.append(")");
/* 1088 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\QYXTQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */