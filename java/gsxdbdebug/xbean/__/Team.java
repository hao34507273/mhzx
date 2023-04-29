/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class Team extends XBean implements xbean.Team
/*      */ {
/*      */   private ArrayList<xbean.TeamMember> members;
/*      */   private ArrayList<xbean.TeamApplicant> applicants;
/*      */   private HashMap<Integer, xbean.TeamDispositionMember> disposition;
/*      */   private int sameteamfightcount;
/*      */   private int zhenfaid;
/*      */   private boolean isfromplatform;
/*      */   private boolean ischangeleadering;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.members.clear();
/*   31 */     this.applicants.clear();
/*   32 */     this.disposition.clear();
/*   33 */     this.sameteamfightcount = 0;
/*   34 */     this.zhenfaid = 0;
/*   35 */     this.isfromplatform = false;
/*   36 */     this.ischangeleadering = false;
/*      */   }
/*      */   
/*      */   Team(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.members = new ArrayList();
/*   43 */     this.applicants = new ArrayList();
/*   44 */     this.disposition = new HashMap();
/*   45 */     this.isfromplatform = false;
/*   46 */     this.ischangeleadering = false;
/*      */   }
/*      */   
/*      */   public Team()
/*      */   {
/*   51 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Team(Team _o_)
/*      */   {
/*   56 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Team(xbean.Team _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   61 */     super(_xp_, _vn_);
/*   62 */     if ((_o1_ instanceof Team)) { assign((Team)_o1_);
/*   63 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   64 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   65 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Team _o_) {
/*   70 */     _o_._xdb_verify_unsafe_();
/*   71 */     this.members = new ArrayList();
/*   72 */     for (xbean.TeamMember _v_ : _o_.members)
/*   73 */       this.members.add(new TeamMember(_v_, this, "members"));
/*   74 */     this.applicants = new ArrayList();
/*   75 */     for (xbean.TeamApplicant _v_ : _o_.applicants)
/*   76 */       this.applicants.add(new TeamApplicant(_v_, this, "applicants"));
/*   77 */     this.disposition = new HashMap();
/*   78 */     for (Map.Entry<Integer, xbean.TeamDispositionMember> _e_ : _o_.disposition.entrySet())
/*   79 */       this.disposition.put(_e_.getKey(), new TeamDispositionMember((xbean.TeamDispositionMember)_e_.getValue(), this, "disposition"));
/*   80 */     this.sameteamfightcount = _o_.sameteamfightcount;
/*   81 */     this.zhenfaid = _o_.zhenfaid;
/*   82 */     this.isfromplatform = _o_.isfromplatform;
/*   83 */     this.ischangeleadering = _o_.ischangeleadering;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   88 */     this.members = new ArrayList();
/*   89 */     for (xbean.TeamMember _v_ : _o_.members)
/*   90 */       this.members.add(new TeamMember(_v_, this, "members"));
/*   91 */     this.applicants = new ArrayList();
/*   92 */     for (xbean.TeamApplicant _v_ : _o_.applicants)
/*   93 */       this.applicants.add(new TeamApplicant(_v_, this, "applicants"));
/*   94 */     this.disposition = new HashMap();
/*   95 */     for (Map.Entry<Integer, xbean.TeamDispositionMember> _e_ : _o_.disposition.entrySet())
/*   96 */       this.disposition.put(_e_.getKey(), new TeamDispositionMember((xbean.TeamDispositionMember)_e_.getValue(), this, "disposition"));
/*   97 */     this.sameteamfightcount = _o_.sameteamfightcount;
/*   98 */     this.zhenfaid = _o_.zhenfaid;
/*   99 */     this.isfromplatform = _o_.isfromplatform;
/*  100 */     this.ischangeleadering = _o_.ischangeleadering;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  106 */     _xdb_verify_unsafe_();
/*  107 */     _os_.compact_uint32(this.members.size());
/*  108 */     for (xbean.TeamMember _v_ : this.members)
/*      */     {
/*  110 */       _v_.marshal(_os_);
/*      */     }
/*  112 */     _os_.compact_uint32(this.applicants.size());
/*  113 */     for (xbean.TeamApplicant _v_ : this.applicants)
/*      */     {
/*  115 */       _v_.marshal(_os_);
/*      */     }
/*  117 */     _os_.compact_uint32(this.disposition.size());
/*  118 */     for (Map.Entry<Integer, xbean.TeamDispositionMember> _e_ : this.disposition.entrySet())
/*      */     {
/*  120 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  121 */       ((xbean.TeamDispositionMember)_e_.getValue()).marshal(_os_);
/*      */     }
/*  123 */     _os_.marshal(this.sameteamfightcount);
/*  124 */     _os_.marshal(this.zhenfaid);
/*  125 */     _os_.marshal(this.isfromplatform);
/*  126 */     _os_.marshal(this.ischangeleadering);
/*  127 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  133 */     _xdb_verify_unsafe_();
/*  134 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  136 */       xbean.TeamMember _v_ = new TeamMember(0, this, "members");
/*  137 */       _v_.unmarshal(_os_);
/*  138 */       this.members.add(_v_);
/*      */     }
/*  140 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  142 */       xbean.TeamApplicant _v_ = new TeamApplicant(0, this, "applicants");
/*  143 */       _v_.unmarshal(_os_);
/*  144 */       this.applicants.add(_v_);
/*      */     }
/*      */     
/*  147 */     int size = _os_.uncompact_uint32();
/*  148 */     if (size >= 12)
/*      */     {
/*  150 */       this.disposition = new HashMap(size * 2);
/*      */     }
/*  152 */     for (; size > 0; size--)
/*      */     {
/*  154 */       int _k_ = 0;
/*  155 */       _k_ = _os_.unmarshal_int();
/*  156 */       xbean.TeamDispositionMember _v_ = new TeamDispositionMember(0, this, "disposition");
/*  157 */       _v_.unmarshal(_os_);
/*  158 */       this.disposition.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  161 */     this.sameteamfightcount = _os_.unmarshal_int();
/*  162 */     this.zhenfaid = _os_.unmarshal_int();
/*  163 */     this.isfromplatform = _os_.unmarshal_boolean();
/*  164 */     this.ischangeleadering = _os_.unmarshal_boolean();
/*  165 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  171 */     _xdb_verify_unsafe_();
/*  172 */     int _size_ = 0;
/*  173 */     for (xbean.TeamMember _v_ : this.members)
/*      */     {
/*  175 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*      */     }
/*  177 */     for (xbean.TeamApplicant _v_ : this.applicants)
/*      */     {
/*  179 */       _size_ += CodedOutputStream.computeMessageSize(2, _v_);
/*      */     }
/*  181 */     for (Map.Entry<Integer, xbean.TeamDispositionMember> _e_ : this.disposition.entrySet())
/*      */     {
/*  183 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  184 */       _size_ += CodedOutputStream.computeMessageSize(4, (ppbio.Message)_e_.getValue());
/*      */     }
/*  186 */     _size_ += CodedOutputStream.computeInt32Size(5, this.sameteamfightcount);
/*  187 */     _size_ += CodedOutputStream.computeInt32Size(6, this.zhenfaid);
/*  188 */     _size_ += CodedOutputStream.computeBoolSize(7, this.isfromplatform);
/*  189 */     _size_ += CodedOutputStream.computeBoolSize(8, this.ischangeleadering);
/*  190 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  196 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  199 */       for (xbean.TeamMember _v_ : this.members)
/*      */       {
/*  201 */         _output_.writeMessage(1, _v_);
/*      */       }
/*  203 */       for (xbean.TeamApplicant _v_ : this.applicants)
/*      */       {
/*  205 */         _output_.writeMessage(2, _v_);
/*      */       }
/*  207 */       for (Map.Entry<Integer, xbean.TeamDispositionMember> _e_ : this.disposition.entrySet())
/*      */       {
/*  209 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  210 */         _output_.writeMessage(4, (ppbio.Message)_e_.getValue());
/*      */       }
/*  212 */       _output_.writeInt32(5, this.sameteamfightcount);
/*  213 */       _output_.writeInt32(6, this.zhenfaid);
/*  214 */       _output_.writeBool(7, this.isfromplatform);
/*  215 */       _output_.writeBool(8, this.ischangeleadering);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  219 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  221 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  227 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  230 */       boolean done = false;
/*  231 */       while (!done)
/*      */       {
/*  233 */         int tag = _input_.readTag();
/*  234 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  238 */           done = true;
/*  239 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  243 */           xbean.TeamMember _v_ = new TeamMember(0, this, "members");
/*  244 */           _input_.readMessage(_v_);
/*  245 */           this.members.add(_v_);
/*  246 */           break;
/*      */         
/*      */ 
/*      */         case 18: 
/*  250 */           xbean.TeamApplicant _v_ = new TeamApplicant(0, this, "applicants");
/*  251 */           _input_.readMessage(_v_);
/*  252 */           this.applicants.add(_v_);
/*  253 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  257 */           int _k_ = 0;
/*  258 */           _k_ = _input_.readInt32();
/*  259 */           int readTag = _input_.readTag();
/*  260 */           if (34 != readTag)
/*      */           {
/*  262 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  264 */           xbean.TeamDispositionMember _v_ = new TeamDispositionMember(0, this, "disposition");
/*  265 */           _input_.readMessage(_v_);
/*  266 */           this.disposition.put(Integer.valueOf(_k_), _v_);
/*  267 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  271 */           this.sameteamfightcount = _input_.readInt32();
/*  272 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  276 */           this.zhenfaid = _input_.readInt32();
/*  277 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  281 */           this.isfromplatform = _input_.readBool();
/*  282 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  286 */           this.ischangeleadering = _input_.readBool();
/*  287 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  291 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  293 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  302 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  306 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  308 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Team copy()
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     return new Team(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Team toData()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Team toBean()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return new Team(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Team toDataIf()
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Team toBeanIf()
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.TeamMember> getMembers()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     return xdb.Logs.logList(new LogKey(this, "members"), this.members);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.TeamMember> getMembersAsData()
/*      */   {
/*  362 */     _xdb_verify_unsafe_();
/*      */     
/*  364 */     Team _o_ = this;
/*  365 */     List<xbean.TeamMember> members = new ArrayList();
/*  366 */     for (xbean.TeamMember _v_ : _o_.members)
/*  367 */       members.add(new TeamMember.Data(_v_));
/*  368 */     return members;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.TeamApplicant> getApplicants()
/*      */   {
/*  375 */     _xdb_verify_unsafe_();
/*  376 */     return xdb.Logs.logList(new LogKey(this, "applicants"), this.applicants);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.TeamApplicant> getApplicantsAsData()
/*      */   {
/*  382 */     _xdb_verify_unsafe_();
/*      */     
/*  384 */     Team _o_ = this;
/*  385 */     List<xbean.TeamApplicant> applicants = new ArrayList();
/*  386 */     for (xbean.TeamApplicant _v_ : _o_.applicants)
/*  387 */       applicants.add(new TeamApplicant.Data(_v_));
/*  388 */     return applicants;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.TeamDispositionMember> getDisposition()
/*      */   {
/*  395 */     _xdb_verify_unsafe_();
/*  396 */     return xdb.Logs.logMap(new LogKey(this, "disposition"), this.disposition);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.TeamDispositionMember> getDispositionAsData()
/*      */   {
/*  403 */     _xdb_verify_unsafe_();
/*      */     
/*  405 */     Team _o_ = this;
/*  406 */     Map<Integer, xbean.TeamDispositionMember> disposition = new HashMap();
/*  407 */     for (Map.Entry<Integer, xbean.TeamDispositionMember> _e_ : _o_.disposition.entrySet())
/*  408 */       disposition.put(_e_.getKey(), new TeamDispositionMember.Data((xbean.TeamDispositionMember)_e_.getValue()));
/*  409 */     return disposition;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSameteamfightcount()
/*      */   {
/*  416 */     _xdb_verify_unsafe_();
/*  417 */     return this.sameteamfightcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getZhenfaid()
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*  425 */     return this.zhenfaid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIsfromplatform()
/*      */   {
/*  432 */     _xdb_verify_unsafe_();
/*  433 */     return this.isfromplatform;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIschangeleadering()
/*      */   {
/*  440 */     _xdb_verify_unsafe_();
/*  441 */     return this.ischangeleadering;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSameteamfightcount(int _v_)
/*      */   {
/*  448 */     _xdb_verify_unsafe_();
/*  449 */     xdb.Logs.logIf(new LogKey(this, "sameteamfightcount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  453 */         new xdb.logs.LogInt(this, Team.this.sameteamfightcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  457 */             Team.this.sameteamfightcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  461 */     });
/*  462 */     this.sameteamfightcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setZhenfaid(int _v_)
/*      */   {
/*  469 */     _xdb_verify_unsafe_();
/*  470 */     xdb.Logs.logIf(new LogKey(this, "zhenfaid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  474 */         new xdb.logs.LogInt(this, Team.this.zhenfaid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  478 */             Team.this.zhenfaid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  482 */     });
/*  483 */     this.zhenfaid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIsfromplatform(boolean _v_)
/*      */   {
/*  490 */     _xdb_verify_unsafe_();
/*  491 */     xdb.Logs.logIf(new LogKey(this, "isfromplatform")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  495 */         new xdb.logs.LogObject(this, Boolean.valueOf(Team.this.isfromplatform))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  499 */             Team.this.isfromplatform = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  503 */     });
/*  504 */     this.isfromplatform = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIschangeleadering(boolean _v_)
/*      */   {
/*  511 */     _xdb_verify_unsafe_();
/*  512 */     xdb.Logs.logIf(new LogKey(this, "ischangeleadering")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  516 */         new xdb.logs.LogObject(this, Boolean.valueOf(Team.this.ischangeleadering))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  520 */             Team.this.ischangeleadering = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  524 */     });
/*  525 */     this.ischangeleadering = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  531 */     _xdb_verify_unsafe_();
/*  532 */     Team _o_ = null;
/*  533 */     if ((_o1_ instanceof Team)) { _o_ = (Team)_o1_;
/*  534 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  535 */       return false;
/*  536 */     if (!this.members.equals(_o_.members)) return false;
/*  537 */     if (!this.applicants.equals(_o_.applicants)) return false;
/*  538 */     if (!this.disposition.equals(_o_.disposition)) return false;
/*  539 */     if (this.sameteamfightcount != _o_.sameteamfightcount) return false;
/*  540 */     if (this.zhenfaid != _o_.zhenfaid) return false;
/*  541 */     if (this.isfromplatform != _o_.isfromplatform) return false;
/*  542 */     if (this.ischangeleadering != _o_.ischangeleadering) return false;
/*  543 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  549 */     _xdb_verify_unsafe_();
/*  550 */     int _h_ = 0;
/*  551 */     _h_ += this.members.hashCode();
/*  552 */     _h_ += this.applicants.hashCode();
/*  553 */     _h_ += this.disposition.hashCode();
/*  554 */     _h_ += this.sameteamfightcount;
/*  555 */     _h_ += this.zhenfaid;
/*  556 */     _h_ += (this.isfromplatform ? 1231 : 1237);
/*  557 */     _h_ += (this.ischangeleadering ? 1231 : 1237);
/*  558 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  564 */     _xdb_verify_unsafe_();
/*  565 */     StringBuilder _sb_ = new StringBuilder();
/*  566 */     _sb_.append("(");
/*  567 */     _sb_.append(this.members);
/*  568 */     _sb_.append(",");
/*  569 */     _sb_.append(this.applicants);
/*  570 */     _sb_.append(",");
/*  571 */     _sb_.append(this.disposition);
/*  572 */     _sb_.append(",");
/*  573 */     _sb_.append(this.sameteamfightcount);
/*  574 */     _sb_.append(",");
/*  575 */     _sb_.append(this.zhenfaid);
/*  576 */     _sb_.append(",");
/*  577 */     _sb_.append(this.isfromplatform);
/*  578 */     _sb_.append(",");
/*  579 */     _sb_.append(this.ischangeleadering);
/*  580 */     _sb_.append(")");
/*  581 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  587 */     ListenableBean lb = new ListenableBean();
/*  588 */     lb.add(new ListenableChanged().setVarName("members"));
/*  589 */     lb.add(new ListenableChanged().setVarName("applicants"));
/*  590 */     lb.add(new xdb.logs.ListenableMap().setVarName("disposition"));
/*  591 */     lb.add(new ListenableChanged().setVarName("sameteamfightcount"));
/*  592 */     lb.add(new ListenableChanged().setVarName("zhenfaid"));
/*  593 */     lb.add(new ListenableChanged().setVarName("isfromplatform"));
/*  594 */     lb.add(new ListenableChanged().setVarName("ischangeleadering"));
/*  595 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Team {
/*      */     private Const() {}
/*      */     
/*      */     Team nThis() {
/*  602 */       return Team.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  608 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Team copy()
/*      */     {
/*  614 */       return Team.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Team toData()
/*      */     {
/*  620 */       return Team.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Team toBean()
/*      */     {
/*  625 */       return Team.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Team toDataIf()
/*      */     {
/*  631 */       return Team.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Team toBeanIf()
/*      */     {
/*  636 */       return Team.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.TeamMember> getMembers()
/*      */     {
/*  643 */       Team.this._xdb_verify_unsafe_();
/*  644 */       return xdb.Consts.constList(Team.this.members);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.TeamMember> getMembersAsData()
/*      */     {
/*  650 */       Team.this._xdb_verify_unsafe_();
/*      */       
/*  652 */       Team _o_ = Team.this;
/*  653 */       List<xbean.TeamMember> members = new ArrayList();
/*  654 */       for (xbean.TeamMember _v_ : _o_.members)
/*  655 */         members.add(new TeamMember.Data(_v_));
/*  656 */       return members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.TeamApplicant> getApplicants()
/*      */     {
/*  663 */       Team.this._xdb_verify_unsafe_();
/*  664 */       return xdb.Consts.constList(Team.this.applicants);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.TeamApplicant> getApplicantsAsData()
/*      */     {
/*  670 */       Team.this._xdb_verify_unsafe_();
/*      */       
/*  672 */       Team _o_ = Team.this;
/*  673 */       List<xbean.TeamApplicant> applicants = new ArrayList();
/*  674 */       for (xbean.TeamApplicant _v_ : _o_.applicants)
/*  675 */         applicants.add(new TeamApplicant.Data(_v_));
/*  676 */       return applicants;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TeamDispositionMember> getDisposition()
/*      */     {
/*  683 */       Team.this._xdb_verify_unsafe_();
/*  684 */       return xdb.Consts.constMap(Team.this.disposition);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TeamDispositionMember> getDispositionAsData()
/*      */     {
/*  691 */       Team.this._xdb_verify_unsafe_();
/*      */       
/*  693 */       Team _o_ = Team.this;
/*  694 */       Map<Integer, xbean.TeamDispositionMember> disposition = new HashMap();
/*  695 */       for (Map.Entry<Integer, xbean.TeamDispositionMember> _e_ : _o_.disposition.entrySet())
/*  696 */         disposition.put(_e_.getKey(), new TeamDispositionMember.Data((xbean.TeamDispositionMember)_e_.getValue()));
/*  697 */       return disposition;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSameteamfightcount()
/*      */     {
/*  704 */       Team.this._xdb_verify_unsafe_();
/*  705 */       return Team.this.sameteamfightcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getZhenfaid()
/*      */     {
/*  712 */       Team.this._xdb_verify_unsafe_();
/*  713 */       return Team.this.zhenfaid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsfromplatform()
/*      */     {
/*  720 */       Team.this._xdb_verify_unsafe_();
/*  721 */       return Team.this.isfromplatform;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIschangeleadering()
/*      */     {
/*  728 */       Team.this._xdb_verify_unsafe_();
/*  729 */       return Team.this.ischangeleadering;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSameteamfightcount(int _v_)
/*      */     {
/*  736 */       Team.this._xdb_verify_unsafe_();
/*  737 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setZhenfaid(int _v_)
/*      */     {
/*  744 */       Team.this._xdb_verify_unsafe_();
/*  745 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsfromplatform(boolean _v_)
/*      */     {
/*  752 */       Team.this._xdb_verify_unsafe_();
/*  753 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIschangeleadering(boolean _v_)
/*      */     {
/*  760 */       Team.this._xdb_verify_unsafe_();
/*  761 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  767 */       Team.this._xdb_verify_unsafe_();
/*  768 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  774 */       Team.this._xdb_verify_unsafe_();
/*  775 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  781 */       return Team.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  787 */       return Team.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  793 */       Team.this._xdb_verify_unsafe_();
/*  794 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  800 */       return Team.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  806 */       return Team.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  812 */       Team.this._xdb_verify_unsafe_();
/*  813 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  819 */       return Team.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  825 */       return Team.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  831 */       return Team.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  837 */       return Team.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  843 */       return Team.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  849 */       return Team.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  855 */       return Team.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Team
/*      */   {
/*      */     private ArrayList<xbean.TeamMember> members;
/*      */     
/*      */     private ArrayList<xbean.TeamApplicant> applicants;
/*      */     
/*      */     private HashMap<Integer, xbean.TeamDispositionMember> disposition;
/*      */     
/*      */     private int sameteamfightcount;
/*      */     
/*      */     private int zhenfaid;
/*      */     
/*      */     private boolean isfromplatform;
/*      */     
/*      */     private boolean ischangeleadering;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  879 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  884 */       this.members = new ArrayList();
/*  885 */       this.applicants = new ArrayList();
/*  886 */       this.disposition = new HashMap();
/*  887 */       this.isfromplatform = false;
/*  888 */       this.ischangeleadering = false;
/*      */     }
/*      */     
/*      */     Data(xbean.Team _o1_)
/*      */     {
/*  893 */       if ((_o1_ instanceof Team)) { assign((Team)_o1_);
/*  894 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  895 */       } else if ((_o1_ instanceof Team.Const)) assign(((Team.Const)_o1_).nThis()); else {
/*  896 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Team _o_) {
/*  901 */       this.members = new ArrayList();
/*  902 */       for (xbean.TeamMember _v_ : _o_.members)
/*  903 */         this.members.add(new TeamMember.Data(_v_));
/*  904 */       this.applicants = new ArrayList();
/*  905 */       for (xbean.TeamApplicant _v_ : _o_.applicants)
/*  906 */         this.applicants.add(new TeamApplicant.Data(_v_));
/*  907 */       this.disposition = new HashMap();
/*  908 */       for (Map.Entry<Integer, xbean.TeamDispositionMember> _e_ : _o_.disposition.entrySet())
/*  909 */         this.disposition.put(_e_.getKey(), new TeamDispositionMember.Data((xbean.TeamDispositionMember)_e_.getValue()));
/*  910 */       this.sameteamfightcount = _o_.sameteamfightcount;
/*  911 */       this.zhenfaid = _o_.zhenfaid;
/*  912 */       this.isfromplatform = _o_.isfromplatform;
/*  913 */       this.ischangeleadering = _o_.ischangeleadering;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  918 */       this.members = new ArrayList();
/*  919 */       for (xbean.TeamMember _v_ : _o_.members)
/*  920 */         this.members.add(new TeamMember.Data(_v_));
/*  921 */       this.applicants = new ArrayList();
/*  922 */       for (xbean.TeamApplicant _v_ : _o_.applicants)
/*  923 */         this.applicants.add(new TeamApplicant.Data(_v_));
/*  924 */       this.disposition = new HashMap();
/*  925 */       for (Map.Entry<Integer, xbean.TeamDispositionMember> _e_ : _o_.disposition.entrySet())
/*  926 */         this.disposition.put(_e_.getKey(), new TeamDispositionMember.Data((xbean.TeamDispositionMember)_e_.getValue()));
/*  927 */       this.sameteamfightcount = _o_.sameteamfightcount;
/*  928 */       this.zhenfaid = _o_.zhenfaid;
/*  929 */       this.isfromplatform = _o_.isfromplatform;
/*  930 */       this.ischangeleadering = _o_.ischangeleadering;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  936 */       _os_.compact_uint32(this.members.size());
/*  937 */       for (xbean.TeamMember _v_ : this.members)
/*      */       {
/*  939 */         _v_.marshal(_os_);
/*      */       }
/*  941 */       _os_.compact_uint32(this.applicants.size());
/*  942 */       for (xbean.TeamApplicant _v_ : this.applicants)
/*      */       {
/*  944 */         _v_.marshal(_os_);
/*      */       }
/*  946 */       _os_.compact_uint32(this.disposition.size());
/*  947 */       for (Map.Entry<Integer, xbean.TeamDispositionMember> _e_ : this.disposition.entrySet())
/*      */       {
/*  949 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  950 */         ((xbean.TeamDispositionMember)_e_.getValue()).marshal(_os_);
/*      */       }
/*  952 */       _os_.marshal(this.sameteamfightcount);
/*  953 */       _os_.marshal(this.zhenfaid);
/*  954 */       _os_.marshal(this.isfromplatform);
/*  955 */       _os_.marshal(this.ischangeleadering);
/*  956 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  962 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  964 */         xbean.TeamMember _v_ = xbean.Pod.newTeamMemberData();
/*  965 */         _v_.unmarshal(_os_);
/*  966 */         this.members.add(_v_);
/*      */       }
/*  968 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  970 */         xbean.TeamApplicant _v_ = xbean.Pod.newTeamApplicantData();
/*  971 */         _v_.unmarshal(_os_);
/*  972 */         this.applicants.add(_v_);
/*      */       }
/*      */       
/*  975 */       int size = _os_.uncompact_uint32();
/*  976 */       if (size >= 12)
/*      */       {
/*  978 */         this.disposition = new HashMap(size * 2);
/*      */       }
/*  980 */       for (; size > 0; size--)
/*      */       {
/*  982 */         int _k_ = 0;
/*  983 */         _k_ = _os_.unmarshal_int();
/*  984 */         xbean.TeamDispositionMember _v_ = xbean.Pod.newTeamDispositionMemberData();
/*  985 */         _v_.unmarshal(_os_);
/*  986 */         this.disposition.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  989 */       this.sameteamfightcount = _os_.unmarshal_int();
/*  990 */       this.zhenfaid = _os_.unmarshal_int();
/*  991 */       this.isfromplatform = _os_.unmarshal_boolean();
/*  992 */       this.ischangeleadering = _os_.unmarshal_boolean();
/*  993 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  999 */       int _size_ = 0;
/* 1000 */       for (xbean.TeamMember _v_ : this.members)
/*      */       {
/* 1002 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*      */       }
/* 1004 */       for (xbean.TeamApplicant _v_ : this.applicants)
/*      */       {
/* 1006 */         _size_ += CodedOutputStream.computeMessageSize(2, _v_);
/*      */       }
/* 1008 */       for (Map.Entry<Integer, xbean.TeamDispositionMember> _e_ : this.disposition.entrySet())
/*      */       {
/* 1010 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/* 1011 */         _size_ += CodedOutputStream.computeMessageSize(4, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1013 */       _size_ += CodedOutputStream.computeInt32Size(5, this.sameteamfightcount);
/* 1014 */       _size_ += CodedOutputStream.computeInt32Size(6, this.zhenfaid);
/* 1015 */       _size_ += CodedOutputStream.computeBoolSize(7, this.isfromplatform);
/* 1016 */       _size_ += CodedOutputStream.computeBoolSize(8, this.ischangeleadering);
/* 1017 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1025 */         for (xbean.TeamMember _v_ : this.members)
/*      */         {
/* 1027 */           _output_.writeMessage(1, _v_);
/*      */         }
/* 1029 */         for (xbean.TeamApplicant _v_ : this.applicants)
/*      */         {
/* 1031 */           _output_.writeMessage(2, _v_);
/*      */         }
/* 1033 */         for (Map.Entry<Integer, xbean.TeamDispositionMember> _e_ : this.disposition.entrySet())
/*      */         {
/* 1035 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/* 1036 */           _output_.writeMessage(4, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1038 */         _output_.writeInt32(5, this.sameteamfightcount);
/* 1039 */         _output_.writeInt32(6, this.zhenfaid);
/* 1040 */         _output_.writeBool(7, this.isfromplatform);
/* 1041 */         _output_.writeBool(8, this.ischangeleadering);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1045 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1047 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1055 */         boolean done = false;
/* 1056 */         while (!done)
/*      */         {
/* 1058 */           int tag = _input_.readTag();
/* 1059 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1063 */             done = true;
/* 1064 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/* 1068 */             xbean.TeamMember _v_ = xbean.Pod.newTeamMemberData();
/* 1069 */             _input_.readMessage(_v_);
/* 1070 */             this.members.add(_v_);
/* 1071 */             break;
/*      */           
/*      */ 
/*      */           case 18: 
/* 1075 */             xbean.TeamApplicant _v_ = xbean.Pod.newTeamApplicantData();
/* 1076 */             _input_.readMessage(_v_);
/* 1077 */             this.applicants.add(_v_);
/* 1078 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1082 */             int _k_ = 0;
/* 1083 */             _k_ = _input_.readInt32();
/* 1084 */             int readTag = _input_.readTag();
/* 1085 */             if (34 != readTag)
/*      */             {
/* 1087 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1089 */             xbean.TeamDispositionMember _v_ = xbean.Pod.newTeamDispositionMemberData();
/* 1090 */             _input_.readMessage(_v_);
/* 1091 */             this.disposition.put(Integer.valueOf(_k_), _v_);
/* 1092 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1096 */             this.sameteamfightcount = _input_.readInt32();
/* 1097 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1101 */             this.zhenfaid = _input_.readInt32();
/* 1102 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1106 */             this.isfromplatform = _input_.readBool();
/* 1107 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1111 */             this.ischangeleadering = _input_.readBool();
/* 1112 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1116 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1118 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1127 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1131 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1133 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Team copy()
/*      */     {
/* 1139 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Team toData()
/*      */     {
/* 1145 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Team toBean()
/*      */     {
/* 1150 */       return new Team(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Team toDataIf()
/*      */     {
/* 1156 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Team toBeanIf()
/*      */     {
/* 1161 */       return new Team(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1167 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1171 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1175 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1179 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1183 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1187 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1191 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.TeamMember> getMembers()
/*      */     {
/* 1198 */       return this.members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.TeamMember> getMembersAsData()
/*      */     {
/* 1205 */       return this.members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.TeamApplicant> getApplicants()
/*      */     {
/* 1212 */       return this.applicants;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.TeamApplicant> getApplicantsAsData()
/*      */     {
/* 1219 */       return this.applicants;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TeamDispositionMember> getDisposition()
/*      */     {
/* 1226 */       return this.disposition;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TeamDispositionMember> getDispositionAsData()
/*      */     {
/* 1233 */       return this.disposition;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSameteamfightcount()
/*      */     {
/* 1240 */       return this.sameteamfightcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getZhenfaid()
/*      */     {
/* 1247 */       return this.zhenfaid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsfromplatform()
/*      */     {
/* 1254 */       return this.isfromplatform;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIschangeleadering()
/*      */     {
/* 1261 */       return this.ischangeleadering;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSameteamfightcount(int _v_)
/*      */     {
/* 1268 */       this.sameteamfightcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setZhenfaid(int _v_)
/*      */     {
/* 1275 */       this.zhenfaid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsfromplatform(boolean _v_)
/*      */     {
/* 1282 */       this.isfromplatform = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIschangeleadering(boolean _v_)
/*      */     {
/* 1289 */       this.ischangeleadering = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1295 */       if (!(_o1_ instanceof Data)) return false;
/* 1296 */       Data _o_ = (Data)_o1_;
/* 1297 */       if (!this.members.equals(_o_.members)) return false;
/* 1298 */       if (!this.applicants.equals(_o_.applicants)) return false;
/* 1299 */       if (!this.disposition.equals(_o_.disposition)) return false;
/* 1300 */       if (this.sameteamfightcount != _o_.sameteamfightcount) return false;
/* 1301 */       if (this.zhenfaid != _o_.zhenfaid) return false;
/* 1302 */       if (this.isfromplatform != _o_.isfromplatform) return false;
/* 1303 */       if (this.ischangeleadering != _o_.ischangeleadering) return false;
/* 1304 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1310 */       int _h_ = 0;
/* 1311 */       _h_ += this.members.hashCode();
/* 1312 */       _h_ += this.applicants.hashCode();
/* 1313 */       _h_ += this.disposition.hashCode();
/* 1314 */       _h_ += this.sameteamfightcount;
/* 1315 */       _h_ += this.zhenfaid;
/* 1316 */       _h_ += (this.isfromplatform ? 1231 : 1237);
/* 1317 */       _h_ += (this.ischangeleadering ? 1231 : 1237);
/* 1318 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1324 */       StringBuilder _sb_ = new StringBuilder();
/* 1325 */       _sb_.append("(");
/* 1326 */       _sb_.append(this.members);
/* 1327 */       _sb_.append(",");
/* 1328 */       _sb_.append(this.applicants);
/* 1329 */       _sb_.append(",");
/* 1330 */       _sb_.append(this.disposition);
/* 1331 */       _sb_.append(",");
/* 1332 */       _sb_.append(this.sameteamfightcount);
/* 1333 */       _sb_.append(",");
/* 1334 */       _sb_.append(this.zhenfaid);
/* 1335 */       _sb_.append(",");
/* 1336 */       _sb_.append(this.isfromplatform);
/* 1337 */       _sb_.append(",");
/* 1338 */       _sb_.append(this.ischangeleadering);
/* 1339 */       _sb_.append(")");
/* 1340 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Team.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */