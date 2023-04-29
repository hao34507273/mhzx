/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ 
/*      */ public final class PictureQuestionInfo extends XBean implements xbean.PictureQuestionInfo
/*      */ {
/*      */   private int questionid;
/*      */   private long answerroleid;
/*      */   private LinkedList<Integer> wronganswerlist;
/*      */   private int rightanswer;
/*      */   private HashMap<Integer, Integer> parammap;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.questionid = 0;
/*   27 */     this.answerroleid = 0L;
/*   28 */     this.wronganswerlist.clear();
/*   29 */     this.rightanswer = 0;
/*   30 */     this.parammap.clear();
/*      */   }
/*      */   
/*      */   PictureQuestionInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.wronganswerlist = new LinkedList();
/*   37 */     this.parammap = new HashMap();
/*      */   }
/*      */   
/*      */   public PictureQuestionInfo()
/*      */   {
/*   42 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public PictureQuestionInfo(PictureQuestionInfo _o_)
/*      */   {
/*   47 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   PictureQuestionInfo(xbean.PictureQuestionInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   52 */     super(_xp_, _vn_);
/*   53 */     if ((_o1_ instanceof PictureQuestionInfo)) { assign((PictureQuestionInfo)_o1_);
/*   54 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   55 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   56 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(PictureQuestionInfo _o_) {
/*   61 */     _o_._xdb_verify_unsafe_();
/*   62 */     this.questionid = _o_.questionid;
/*   63 */     this.answerroleid = _o_.answerroleid;
/*   64 */     this.wronganswerlist = new LinkedList();
/*   65 */     this.wronganswerlist.addAll(_o_.wronganswerlist);
/*   66 */     this.rightanswer = _o_.rightanswer;
/*   67 */     this.parammap = new HashMap();
/*   68 */     for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet()) {
/*   69 */       this.parammap.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   74 */     this.questionid = _o_.questionid;
/*   75 */     this.answerroleid = _o_.answerroleid;
/*   76 */     this.wronganswerlist = new LinkedList();
/*   77 */     this.wronganswerlist.addAll(_o_.wronganswerlist);
/*   78 */     this.rightanswer = _o_.rightanswer;
/*   79 */     this.parammap = new HashMap();
/*   80 */     for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet()) {
/*   81 */       this.parammap.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   87 */     _xdb_verify_unsafe_();
/*   88 */     _os_.marshal(this.questionid);
/*   89 */     _os_.marshal(this.answerroleid);
/*   90 */     _os_.compact_uint32(this.wronganswerlist.size());
/*   91 */     for (Integer _v_ : this.wronganswerlist)
/*      */     {
/*   93 */       _os_.marshal(_v_.intValue());
/*      */     }
/*   95 */     _os_.marshal(this.rightanswer);
/*   96 */     _os_.compact_uint32(this.parammap.size());
/*   97 */     for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*      */     {
/*   99 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  100 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  102 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  108 */     _xdb_verify_unsafe_();
/*  109 */     this.questionid = _os_.unmarshal_int();
/*  110 */     this.answerroleid = _os_.unmarshal_long();
/*  111 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  113 */       int _v_ = 0;
/*  114 */       _v_ = _os_.unmarshal_int();
/*  115 */       this.wronganswerlist.add(Integer.valueOf(_v_));
/*      */     }
/*  117 */     this.rightanswer = _os_.unmarshal_int();
/*      */     
/*  119 */     int size = _os_.uncompact_uint32();
/*  120 */     if (size >= 12)
/*      */     {
/*  122 */       this.parammap = new HashMap(size * 2);
/*      */     }
/*  124 */     for (; size > 0; size--)
/*      */     {
/*  126 */       int _k_ = 0;
/*  127 */       _k_ = _os_.unmarshal_int();
/*  128 */       int _v_ = 0;
/*  129 */       _v_ = _os_.unmarshal_int();
/*  130 */       this.parammap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  133 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  139 */     _xdb_verify_unsafe_();
/*  140 */     int _size_ = 0;
/*  141 */     _size_ += CodedOutputStream.computeInt32Size(1, this.questionid);
/*  142 */     _size_ += CodedOutputStream.computeInt64Size(2, this.answerroleid);
/*  143 */     for (Integer _v_ : this.wronganswerlist)
/*      */     {
/*  145 */       _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*      */     }
/*  147 */     _size_ += CodedOutputStream.computeInt32Size(4, this.rightanswer);
/*  148 */     for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*      */     {
/*  150 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  151 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  153 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  159 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  162 */       _output_.writeInt32(1, this.questionid);
/*  163 */       _output_.writeInt64(2, this.answerroleid);
/*  164 */       for (Integer _v_ : this.wronganswerlist)
/*      */       {
/*  166 */         _output_.writeInt32(3, _v_.intValue());
/*      */       }
/*  168 */       _output_.writeInt32(4, this.rightanswer);
/*  169 */       for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*      */       {
/*  171 */         _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  172 */         _output_.writeInt32(5, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  177 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  179 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  185 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  188 */       boolean done = false;
/*  189 */       while (!done)
/*      */       {
/*  191 */         int tag = _input_.readTag();
/*  192 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  196 */           done = true;
/*  197 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  201 */           this.questionid = _input_.readInt32();
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  206 */           this.answerroleid = _input_.readInt64();
/*  207 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  211 */           int _v_ = 0;
/*  212 */           _v_ = _input_.readInt32();
/*  213 */           this.wronganswerlist.add(Integer.valueOf(_v_));
/*  214 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  218 */           this.rightanswer = _input_.readInt32();
/*  219 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  223 */           int _k_ = 0;
/*  224 */           _k_ = _input_.readInt32();
/*  225 */           int readTag = _input_.readTag();
/*  226 */           if (40 != readTag)
/*      */           {
/*  228 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  230 */           int _v_ = 0;
/*  231 */           _v_ = _input_.readInt32();
/*  232 */           this.parammap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  233 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  237 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  239 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  248 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  252 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  254 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PictureQuestionInfo copy()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return new PictureQuestionInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PictureQuestionInfo toData()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PictureQuestionInfo toBean()
/*      */   {
/*  273 */     _xdb_verify_unsafe_();
/*  274 */     return new PictureQuestionInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PictureQuestionInfo toDataIf()
/*      */   {
/*  280 */     _xdb_verify_unsafe_();
/*  281 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PictureQuestionInfo toBeanIf()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  293 */     _xdb_verify_unsafe_();
/*  294 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getQuestionid()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*  302 */     return this.questionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAnswerroleid()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*  310 */     return this.answerroleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getWronganswerlist()
/*      */   {
/*  317 */     _xdb_verify_unsafe_();
/*  318 */     return xdb.Logs.logList(new LogKey(this, "wronganswerlist"), this.wronganswerlist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getWronganswerlistAsData()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*      */     
/*  326 */     PictureQuestionInfo _o_ = this;
/*  327 */     List<Integer> wronganswerlist = new LinkedList();
/*  328 */     wronganswerlist.addAll(_o_.wronganswerlist);
/*  329 */     return wronganswerlist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRightanswer()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     return this.rightanswer;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getParammap()
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     return xdb.Logs.logMap(new LogKey(this, "parammap"), this.parammap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getParammapAsData()
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*      */     
/*  354 */     PictureQuestionInfo _o_ = this;
/*  355 */     Map<Integer, Integer> parammap = new HashMap();
/*  356 */     for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet())
/*  357 */       parammap.put(_e_.getKey(), _e_.getValue());
/*  358 */     return parammap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setQuestionid(int _v_)
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     xdb.Logs.logIf(new LogKey(this, "questionid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  370 */         new xdb.logs.LogInt(this, PictureQuestionInfo.this.questionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  374 */             PictureQuestionInfo.this.questionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  378 */     });
/*  379 */     this.questionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAnswerroleid(long _v_)
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     xdb.Logs.logIf(new LogKey(this, "answerroleid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  391 */         new xdb.logs.LogLong(this, PictureQuestionInfo.this.answerroleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  395 */             PictureQuestionInfo.this.answerroleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  399 */     });
/*  400 */     this.answerroleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRightanswer(int _v_)
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     xdb.Logs.logIf(new LogKey(this, "rightanswer")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  412 */         new xdb.logs.LogInt(this, PictureQuestionInfo.this.rightanswer)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  416 */             PictureQuestionInfo.this.rightanswer = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  420 */     });
/*  421 */     this.rightanswer = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     PictureQuestionInfo _o_ = null;
/*  429 */     if ((_o1_ instanceof PictureQuestionInfo)) { _o_ = (PictureQuestionInfo)_o1_;
/*  430 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  431 */       return false;
/*  432 */     if (this.questionid != _o_.questionid) return false;
/*  433 */     if (this.answerroleid != _o_.answerroleid) return false;
/*  434 */     if (!this.wronganswerlist.equals(_o_.wronganswerlist)) return false;
/*  435 */     if (this.rightanswer != _o_.rightanswer) return false;
/*  436 */     if (!this.parammap.equals(_o_.parammap)) return false;
/*  437 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*  444 */     int _h_ = 0;
/*  445 */     _h_ += this.questionid;
/*  446 */     _h_ = (int)(_h_ + this.answerroleid);
/*  447 */     _h_ += this.wronganswerlist.hashCode();
/*  448 */     _h_ += this.rightanswer;
/*  449 */     _h_ += this.parammap.hashCode();
/*  450 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  456 */     _xdb_verify_unsafe_();
/*  457 */     StringBuilder _sb_ = new StringBuilder();
/*  458 */     _sb_.append("(");
/*  459 */     _sb_.append(this.questionid);
/*  460 */     _sb_.append(",");
/*  461 */     _sb_.append(this.answerroleid);
/*  462 */     _sb_.append(",");
/*  463 */     _sb_.append(this.wronganswerlist);
/*  464 */     _sb_.append(",");
/*  465 */     _sb_.append(this.rightanswer);
/*  466 */     _sb_.append(",");
/*  467 */     _sb_.append(this.parammap);
/*  468 */     _sb_.append(")");
/*  469 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  475 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  476 */     lb.add(new xdb.logs.ListenableChanged().setVarName("questionid"));
/*  477 */     lb.add(new xdb.logs.ListenableChanged().setVarName("answerroleid"));
/*  478 */     lb.add(new xdb.logs.ListenableChanged().setVarName("wronganswerlist"));
/*  479 */     lb.add(new xdb.logs.ListenableChanged().setVarName("rightanswer"));
/*  480 */     lb.add(new xdb.logs.ListenableMap().setVarName("parammap"));
/*  481 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.PictureQuestionInfo {
/*      */     private Const() {}
/*      */     
/*      */     PictureQuestionInfo nThis() {
/*  488 */       return PictureQuestionInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  494 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PictureQuestionInfo copy()
/*      */     {
/*  500 */       return PictureQuestionInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PictureQuestionInfo toData()
/*      */     {
/*  506 */       return PictureQuestionInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.PictureQuestionInfo toBean()
/*      */     {
/*  511 */       return PictureQuestionInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PictureQuestionInfo toDataIf()
/*      */     {
/*  517 */       return PictureQuestionInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.PictureQuestionInfo toBeanIf()
/*      */     {
/*  522 */       return PictureQuestionInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getQuestionid()
/*      */     {
/*  529 */       PictureQuestionInfo.this._xdb_verify_unsafe_();
/*  530 */       return PictureQuestionInfo.this.questionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAnswerroleid()
/*      */     {
/*  537 */       PictureQuestionInfo.this._xdb_verify_unsafe_();
/*  538 */       return PictureQuestionInfo.this.answerroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getWronganswerlist()
/*      */     {
/*  545 */       PictureQuestionInfo.this._xdb_verify_unsafe_();
/*  546 */       return xdb.Consts.constList(PictureQuestionInfo.this.wronganswerlist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getWronganswerlistAsData()
/*      */     {
/*  552 */       PictureQuestionInfo.this._xdb_verify_unsafe_();
/*      */       
/*  554 */       PictureQuestionInfo _o_ = PictureQuestionInfo.this;
/*  555 */       List<Integer> wronganswerlist = new LinkedList();
/*  556 */       wronganswerlist.addAll(_o_.wronganswerlist);
/*  557 */       return wronganswerlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRightanswer()
/*      */     {
/*  564 */       PictureQuestionInfo.this._xdb_verify_unsafe_();
/*  565 */       return PictureQuestionInfo.this.rightanswer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getParammap()
/*      */     {
/*  572 */       PictureQuestionInfo.this._xdb_verify_unsafe_();
/*  573 */       return xdb.Consts.constMap(PictureQuestionInfo.this.parammap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getParammapAsData()
/*      */     {
/*  580 */       PictureQuestionInfo.this._xdb_verify_unsafe_();
/*      */       
/*  582 */       PictureQuestionInfo _o_ = PictureQuestionInfo.this;
/*  583 */       Map<Integer, Integer> parammap = new HashMap();
/*  584 */       for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet())
/*  585 */         parammap.put(_e_.getKey(), _e_.getValue());
/*  586 */       return parammap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setQuestionid(int _v_)
/*      */     {
/*  593 */       PictureQuestionInfo.this._xdb_verify_unsafe_();
/*  594 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnswerroleid(long _v_)
/*      */     {
/*  601 */       PictureQuestionInfo.this._xdb_verify_unsafe_();
/*  602 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRightanswer(int _v_)
/*      */     {
/*  609 */       PictureQuestionInfo.this._xdb_verify_unsafe_();
/*  610 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  616 */       PictureQuestionInfo.this._xdb_verify_unsafe_();
/*  617 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  623 */       PictureQuestionInfo.this._xdb_verify_unsafe_();
/*  624 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  630 */       return PictureQuestionInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  636 */       return PictureQuestionInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  642 */       PictureQuestionInfo.this._xdb_verify_unsafe_();
/*  643 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  649 */       return PictureQuestionInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  655 */       return PictureQuestionInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  661 */       PictureQuestionInfo.this._xdb_verify_unsafe_();
/*  662 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  668 */       return PictureQuestionInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  674 */       return PictureQuestionInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  680 */       return PictureQuestionInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  686 */       return PictureQuestionInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  692 */       return PictureQuestionInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  698 */       return PictureQuestionInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  704 */       return PictureQuestionInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.PictureQuestionInfo
/*      */   {
/*      */     private int questionid;
/*      */     
/*      */     private long answerroleid;
/*      */     
/*      */     private LinkedList<Integer> wronganswerlist;
/*      */     
/*      */     private int rightanswer;
/*      */     
/*      */     private HashMap<Integer, Integer> parammap;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  724 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  729 */       this.wronganswerlist = new LinkedList();
/*  730 */       this.parammap = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.PictureQuestionInfo _o1_)
/*      */     {
/*  735 */       if ((_o1_ instanceof PictureQuestionInfo)) { assign((PictureQuestionInfo)_o1_);
/*  736 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  737 */       } else if ((_o1_ instanceof PictureQuestionInfo.Const)) assign(((PictureQuestionInfo.Const)_o1_).nThis()); else {
/*  738 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(PictureQuestionInfo _o_) {
/*  743 */       this.questionid = _o_.questionid;
/*  744 */       this.answerroleid = _o_.answerroleid;
/*  745 */       this.wronganswerlist = new LinkedList();
/*  746 */       this.wronganswerlist.addAll(_o_.wronganswerlist);
/*  747 */       this.rightanswer = _o_.rightanswer;
/*  748 */       this.parammap = new HashMap();
/*  749 */       for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet()) {
/*  750 */         this.parammap.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  755 */       this.questionid = _o_.questionid;
/*  756 */       this.answerroleid = _o_.answerroleid;
/*  757 */       this.wronganswerlist = new LinkedList();
/*  758 */       this.wronganswerlist.addAll(_o_.wronganswerlist);
/*  759 */       this.rightanswer = _o_.rightanswer;
/*  760 */       this.parammap = new HashMap();
/*  761 */       for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet()) {
/*  762 */         this.parammap.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  768 */       _os_.marshal(this.questionid);
/*  769 */       _os_.marshal(this.answerroleid);
/*  770 */       _os_.compact_uint32(this.wronganswerlist.size());
/*  771 */       for (Integer _v_ : this.wronganswerlist)
/*      */       {
/*  773 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  775 */       _os_.marshal(this.rightanswer);
/*  776 */       _os_.compact_uint32(this.parammap.size());
/*  777 */       for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*      */       {
/*  779 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  780 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  782 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  788 */       this.questionid = _os_.unmarshal_int();
/*  789 */       this.answerroleid = _os_.unmarshal_long();
/*  790 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  792 */         int _v_ = 0;
/*  793 */         _v_ = _os_.unmarshal_int();
/*  794 */         this.wronganswerlist.add(Integer.valueOf(_v_));
/*      */       }
/*  796 */       this.rightanswer = _os_.unmarshal_int();
/*      */       
/*  798 */       int size = _os_.uncompact_uint32();
/*  799 */       if (size >= 12)
/*      */       {
/*  801 */         this.parammap = new HashMap(size * 2);
/*      */       }
/*  803 */       for (; size > 0; size--)
/*      */       {
/*  805 */         int _k_ = 0;
/*  806 */         _k_ = _os_.unmarshal_int();
/*  807 */         int _v_ = 0;
/*  808 */         _v_ = _os_.unmarshal_int();
/*  809 */         this.parammap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  812 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  818 */       int _size_ = 0;
/*  819 */       _size_ += CodedOutputStream.computeInt32Size(1, this.questionid);
/*  820 */       _size_ += CodedOutputStream.computeInt64Size(2, this.answerroleid);
/*  821 */       for (Integer _v_ : this.wronganswerlist)
/*      */       {
/*  823 */         _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*      */       }
/*  825 */       _size_ += CodedOutputStream.computeInt32Size(4, this.rightanswer);
/*  826 */       for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*      */       {
/*  828 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  829 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  831 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  839 */         _output_.writeInt32(1, this.questionid);
/*  840 */         _output_.writeInt64(2, this.answerroleid);
/*  841 */         for (Integer _v_ : this.wronganswerlist)
/*      */         {
/*  843 */           _output_.writeInt32(3, _v_.intValue());
/*      */         }
/*  845 */         _output_.writeInt32(4, this.rightanswer);
/*  846 */         for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*      */         {
/*  848 */           _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  849 */           _output_.writeInt32(5, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  854 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  856 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  864 */         boolean done = false;
/*  865 */         while (!done)
/*      */         {
/*  867 */           int tag = _input_.readTag();
/*  868 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  872 */             done = true;
/*  873 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  877 */             this.questionid = _input_.readInt32();
/*  878 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  882 */             this.answerroleid = _input_.readInt64();
/*  883 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  887 */             int _v_ = 0;
/*  888 */             _v_ = _input_.readInt32();
/*  889 */             this.wronganswerlist.add(Integer.valueOf(_v_));
/*  890 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  894 */             this.rightanswer = _input_.readInt32();
/*  895 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  899 */             int _k_ = 0;
/*  900 */             _k_ = _input_.readInt32();
/*  901 */             int readTag = _input_.readTag();
/*  902 */             if (40 != readTag)
/*      */             {
/*  904 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  906 */             int _v_ = 0;
/*  907 */             _v_ = _input_.readInt32();
/*  908 */             this.parammap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  909 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  913 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  915 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  924 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  928 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  930 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PictureQuestionInfo copy()
/*      */     {
/*  936 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PictureQuestionInfo toData()
/*      */     {
/*  942 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.PictureQuestionInfo toBean()
/*      */     {
/*  947 */       return new PictureQuestionInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PictureQuestionInfo toDataIf()
/*      */     {
/*  953 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.PictureQuestionInfo toBeanIf()
/*      */     {
/*  958 */       return new PictureQuestionInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  964 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  968 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  972 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  976 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  980 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  984 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  988 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getQuestionid()
/*      */     {
/*  995 */       return this.questionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAnswerroleid()
/*      */     {
/* 1002 */       return this.answerroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getWronganswerlist()
/*      */     {
/* 1009 */       return this.wronganswerlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getWronganswerlistAsData()
/*      */     {
/* 1016 */       return this.wronganswerlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRightanswer()
/*      */     {
/* 1023 */       return this.rightanswer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getParammap()
/*      */     {
/* 1030 */       return this.parammap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getParammapAsData()
/*      */     {
/* 1037 */       return this.parammap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setQuestionid(int _v_)
/*      */     {
/* 1044 */       this.questionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnswerroleid(long _v_)
/*      */     {
/* 1051 */       this.answerroleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRightanswer(int _v_)
/*      */     {
/* 1058 */       this.rightanswer = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1064 */       if (!(_o1_ instanceof Data)) return false;
/* 1065 */       Data _o_ = (Data)_o1_;
/* 1066 */       if (this.questionid != _o_.questionid) return false;
/* 1067 */       if (this.answerroleid != _o_.answerroleid) return false;
/* 1068 */       if (!this.wronganswerlist.equals(_o_.wronganswerlist)) return false;
/* 1069 */       if (this.rightanswer != _o_.rightanswer) return false;
/* 1070 */       if (!this.parammap.equals(_o_.parammap)) return false;
/* 1071 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1077 */       int _h_ = 0;
/* 1078 */       _h_ += this.questionid;
/* 1079 */       _h_ = (int)(_h_ + this.answerroleid);
/* 1080 */       _h_ += this.wronganswerlist.hashCode();
/* 1081 */       _h_ += this.rightanswer;
/* 1082 */       _h_ += this.parammap.hashCode();
/* 1083 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1089 */       StringBuilder _sb_ = new StringBuilder();
/* 1090 */       _sb_.append("(");
/* 1091 */       _sb_.append(this.questionid);
/* 1092 */       _sb_.append(",");
/* 1093 */       _sb_.append(this.answerroleid);
/* 1094 */       _sb_.append(",");
/* 1095 */       _sb_.append(this.wronganswerlist);
/* 1096 */       _sb_.append(",");
/* 1097 */       _sb_.append(this.rightanswer);
/* 1098 */       _sb_.append(",");
/* 1099 */       _sb_.append(this.parammap);
/* 1100 */       _sb_.append(")");
/* 1101 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PictureQuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */