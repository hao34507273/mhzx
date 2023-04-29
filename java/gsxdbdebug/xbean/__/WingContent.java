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
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class WingContent extends XBean implements xbean.WingContent
/*      */ {
/*      */   private int cfgid;
/*      */   private int colorid;
/*      */   private ArrayList<Integer> reproids;
/*      */   private ArrayList<Integer> reskillids;
/*      */   private ArrayList<Integer> proids;
/*      */   private ArrayList<Integer> skills;
/*      */   private HashMap<Integer, Integer> target_skills;
/*      */   private int guarantee_times;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.cfgid = 0;
/*   33 */     this.colorid = 0;
/*   34 */     this.reproids.clear();
/*   35 */     this.reskillids.clear();
/*   36 */     this.proids.clear();
/*   37 */     this.skills.clear();
/*   38 */     this.target_skills.clear();
/*   39 */     this.guarantee_times = 0;
/*      */   }
/*      */   
/*      */   WingContent(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.reproids = new ArrayList();
/*   46 */     this.reskillids = new ArrayList();
/*   47 */     this.proids = new ArrayList();
/*   48 */     this.skills = new ArrayList();
/*   49 */     this.target_skills = new HashMap();
/*      */   }
/*      */   
/*      */   public WingContent()
/*      */   {
/*   54 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public WingContent(WingContent _o_)
/*      */   {
/*   59 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   WingContent(xbean.WingContent _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   64 */     super(_xp_, _vn_);
/*   65 */     if ((_o1_ instanceof WingContent)) { assign((WingContent)_o1_);
/*   66 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   67 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   68 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(WingContent _o_) {
/*   73 */     _o_._xdb_verify_unsafe_();
/*   74 */     this.cfgid = _o_.cfgid;
/*   75 */     this.colorid = _o_.colorid;
/*   76 */     this.reproids = new ArrayList();
/*   77 */     this.reproids.addAll(_o_.reproids);
/*   78 */     this.reskillids = new ArrayList();
/*   79 */     this.reskillids.addAll(_o_.reskillids);
/*   80 */     this.proids = new ArrayList();
/*   81 */     this.proids.addAll(_o_.proids);
/*   82 */     this.skills = new ArrayList();
/*   83 */     this.skills.addAll(_o_.skills);
/*   84 */     this.target_skills = new HashMap();
/*   85 */     for (Map.Entry<Integer, Integer> _e_ : _o_.target_skills.entrySet())
/*   86 */       this.target_skills.put(_e_.getKey(), _e_.getValue());
/*   87 */     this.guarantee_times = _o_.guarantee_times;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   92 */     this.cfgid = _o_.cfgid;
/*   93 */     this.colorid = _o_.colorid;
/*   94 */     this.reproids = new ArrayList();
/*   95 */     this.reproids.addAll(_o_.reproids);
/*   96 */     this.reskillids = new ArrayList();
/*   97 */     this.reskillids.addAll(_o_.reskillids);
/*   98 */     this.proids = new ArrayList();
/*   99 */     this.proids.addAll(_o_.proids);
/*  100 */     this.skills = new ArrayList();
/*  101 */     this.skills.addAll(_o_.skills);
/*  102 */     this.target_skills = new HashMap();
/*  103 */     for (Map.Entry<Integer, Integer> _e_ : _o_.target_skills.entrySet())
/*  104 */       this.target_skills.put(_e_.getKey(), _e_.getValue());
/*  105 */     this.guarantee_times = _o_.guarantee_times;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  111 */     _xdb_verify_unsafe_();
/*  112 */     _os_.marshal(this.cfgid);
/*  113 */     _os_.marshal(this.colorid);
/*  114 */     _os_.compact_uint32(this.reproids.size());
/*  115 */     for (Integer _v_ : this.reproids)
/*      */     {
/*  117 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  119 */     _os_.compact_uint32(this.reskillids.size());
/*  120 */     for (Integer _v_ : this.reskillids)
/*      */     {
/*  122 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  124 */     _os_.compact_uint32(this.proids.size());
/*  125 */     for (Integer _v_ : this.proids)
/*      */     {
/*  127 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  129 */     _os_.compact_uint32(this.skills.size());
/*  130 */     for (Integer _v_ : this.skills)
/*      */     {
/*  132 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  134 */     _os_.compact_uint32(this.target_skills.size());
/*  135 */     for (Map.Entry<Integer, Integer> _e_ : this.target_skills.entrySet())
/*      */     {
/*  137 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  138 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  140 */     _os_.marshal(this.guarantee_times);
/*  141 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  147 */     _xdb_verify_unsafe_();
/*  148 */     this.cfgid = _os_.unmarshal_int();
/*  149 */     this.colorid = _os_.unmarshal_int();
/*  150 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  152 */       int _v_ = 0;
/*  153 */       _v_ = _os_.unmarshal_int();
/*  154 */       this.reproids.add(Integer.valueOf(_v_));
/*      */     }
/*  156 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  158 */       int _v_ = 0;
/*  159 */       _v_ = _os_.unmarshal_int();
/*  160 */       this.reskillids.add(Integer.valueOf(_v_));
/*      */     }
/*  162 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  164 */       int _v_ = 0;
/*  165 */       _v_ = _os_.unmarshal_int();
/*  166 */       this.proids.add(Integer.valueOf(_v_));
/*      */     }
/*  168 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  170 */       int _v_ = 0;
/*  171 */       _v_ = _os_.unmarshal_int();
/*  172 */       this.skills.add(Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  175 */     int size = _os_.uncompact_uint32();
/*  176 */     if (size >= 12)
/*      */     {
/*  178 */       this.target_skills = new HashMap(size * 2);
/*      */     }
/*  180 */     for (; size > 0; size--)
/*      */     {
/*  182 */       int _k_ = 0;
/*  183 */       _k_ = _os_.unmarshal_int();
/*  184 */       int _v_ = 0;
/*  185 */       _v_ = _os_.unmarshal_int();
/*  186 */       this.target_skills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  189 */     this.guarantee_times = _os_.unmarshal_int();
/*  190 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  196 */     _xdb_verify_unsafe_();
/*  197 */     int _size_ = 0;
/*  198 */     _size_ += CodedOutputStream.computeInt32Size(1, this.cfgid);
/*  199 */     _size_ += CodedOutputStream.computeInt32Size(2, this.colorid);
/*  200 */     for (Integer _v_ : this.reproids)
/*      */     {
/*  202 */       _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*      */     }
/*  204 */     for (Integer _v_ : this.reskillids)
/*      */     {
/*  206 */       _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */     }
/*  208 */     for (Integer _v_ : this.proids)
/*      */     {
/*  210 */       _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */     }
/*  212 */     for (Integer _v_ : this.skills)
/*      */     {
/*  214 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  216 */     for (Map.Entry<Integer, Integer> _e_ : this.target_skills.entrySet())
/*      */     {
/*  218 */       _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getKey()).intValue());
/*  219 */       _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  221 */     _size_ += CodedOutputStream.computeInt32Size(8, this.guarantee_times);
/*  222 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  228 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  231 */       _output_.writeInt32(1, this.cfgid);
/*  232 */       _output_.writeInt32(2, this.colorid);
/*  233 */       for (Integer _v_ : this.reproids)
/*      */       {
/*  235 */         _output_.writeInt32(3, _v_.intValue());
/*      */       }
/*  237 */       for (Integer _v_ : this.reskillids)
/*      */       {
/*  239 */         _output_.writeInt32(4, _v_.intValue());
/*      */       }
/*  241 */       for (Integer _v_ : this.proids)
/*      */       {
/*  243 */         _output_.writeInt32(5, _v_.intValue());
/*      */       }
/*  245 */       for (Integer _v_ : this.skills)
/*      */       {
/*  247 */         _output_.writeInt32(6, _v_.intValue());
/*      */       }
/*  249 */       for (Map.Entry<Integer, Integer> _e_ : this.target_skills.entrySet())
/*      */       {
/*  251 */         _output_.writeInt32(7, ((Integer)_e_.getKey()).intValue());
/*  252 */         _output_.writeInt32(7, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  254 */       _output_.writeInt32(8, this.guarantee_times);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  258 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  260 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  269 */       boolean done = false;
/*  270 */       while (!done)
/*      */       {
/*  272 */         int tag = _input_.readTag();
/*  273 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  277 */           done = true;
/*  278 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  282 */           this.cfgid = _input_.readInt32();
/*  283 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  287 */           this.colorid = _input_.readInt32();
/*  288 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  292 */           int _v_ = 0;
/*  293 */           _v_ = _input_.readInt32();
/*  294 */           this.reproids.add(Integer.valueOf(_v_));
/*  295 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  299 */           int _v_ = 0;
/*  300 */           _v_ = _input_.readInt32();
/*  301 */           this.reskillids.add(Integer.valueOf(_v_));
/*  302 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  306 */           int _v_ = 0;
/*  307 */           _v_ = _input_.readInt32();
/*  308 */           this.proids.add(Integer.valueOf(_v_));
/*  309 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  313 */           int _v_ = 0;
/*  314 */           _v_ = _input_.readInt32();
/*  315 */           this.skills.add(Integer.valueOf(_v_));
/*  316 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  320 */           int _k_ = 0;
/*  321 */           _k_ = _input_.readInt32();
/*  322 */           int readTag = _input_.readTag();
/*  323 */           if (56 != readTag)
/*      */           {
/*  325 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  327 */           int _v_ = 0;
/*  328 */           _v_ = _input_.readInt32();
/*  329 */           this.target_skills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  330 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  334 */           this.guarantee_times = _input_.readInt32();
/*  335 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  339 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  341 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  350 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  354 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  356 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WingContent copy()
/*      */   {
/*  362 */     _xdb_verify_unsafe_();
/*  363 */     return new WingContent(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WingContent toData()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.WingContent toBean()
/*      */   {
/*  375 */     _xdb_verify_unsafe_();
/*  376 */     return new WingContent(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WingContent toDataIf()
/*      */   {
/*  382 */     _xdb_verify_unsafe_();
/*  383 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.WingContent toBeanIf()
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  395 */     _xdb_verify_unsafe_();
/*  396 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCfgid()
/*      */   {
/*  403 */     _xdb_verify_unsafe_();
/*  404 */     return this.cfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getColorid()
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*  412 */     return this.colorid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getReproids()
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     return Logs.logList(new LogKey(this, "reproids"), this.reproids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getReproidsAsData()
/*      */   {
/*  426 */     _xdb_verify_unsafe_();
/*      */     
/*  428 */     WingContent _o_ = this;
/*  429 */     List<Integer> reproids = new ArrayList();
/*  430 */     reproids.addAll(_o_.reproids);
/*  431 */     return reproids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getReskillids()
/*      */   {
/*  438 */     _xdb_verify_unsafe_();
/*  439 */     return Logs.logList(new LogKey(this, "reskillids"), this.reskillids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getReskillidsAsData()
/*      */   {
/*  445 */     _xdb_verify_unsafe_();
/*      */     
/*  447 */     WingContent _o_ = this;
/*  448 */     List<Integer> reskillids = new ArrayList();
/*  449 */     reskillids.addAll(_o_.reskillids);
/*  450 */     return reskillids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getProids()
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*  458 */     return Logs.logList(new LogKey(this, "proids"), this.proids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getProidsAsData()
/*      */   {
/*  464 */     _xdb_verify_unsafe_();
/*      */     
/*  466 */     WingContent _o_ = this;
/*  467 */     List<Integer> proids = new ArrayList();
/*  468 */     proids.addAll(_o_.proids);
/*  469 */     return proids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getSkills()
/*      */   {
/*  476 */     _xdb_verify_unsafe_();
/*  477 */     return Logs.logList(new LogKey(this, "skills"), this.skills);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getSkillsAsData()
/*      */   {
/*  483 */     _xdb_verify_unsafe_();
/*      */     
/*  485 */     WingContent _o_ = this;
/*  486 */     List<Integer> skills = new ArrayList();
/*  487 */     skills.addAll(_o_.skills);
/*  488 */     return skills;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getTarget_skills()
/*      */   {
/*  495 */     _xdb_verify_unsafe_();
/*  496 */     return Logs.logMap(new LogKey(this, "target_skills"), this.target_skills);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getTarget_skillsAsData()
/*      */   {
/*  503 */     _xdb_verify_unsafe_();
/*      */     
/*  505 */     WingContent _o_ = this;
/*  506 */     Map<Integer, Integer> target_skills = new HashMap();
/*  507 */     for (Map.Entry<Integer, Integer> _e_ : _o_.target_skills.entrySet())
/*  508 */       target_skills.put(_e_.getKey(), _e_.getValue());
/*  509 */     return target_skills;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGuarantee_times()
/*      */   {
/*  516 */     _xdb_verify_unsafe_();
/*  517 */     return this.guarantee_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCfgid(int _v_)
/*      */   {
/*  524 */     _xdb_verify_unsafe_();
/*  525 */     Logs.logIf(new LogKey(this, "cfgid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  529 */         new xdb.logs.LogInt(this, WingContent.this.cfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  533 */             WingContent.this.cfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  537 */     });
/*  538 */     this.cfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setColorid(int _v_)
/*      */   {
/*  545 */     _xdb_verify_unsafe_();
/*  546 */     Logs.logIf(new LogKey(this, "colorid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  550 */         new xdb.logs.LogInt(this, WingContent.this.colorid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  554 */             WingContent.this.colorid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  558 */     });
/*  559 */     this.colorid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGuarantee_times(int _v_)
/*      */   {
/*  566 */     _xdb_verify_unsafe_();
/*  567 */     Logs.logIf(new LogKey(this, "guarantee_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  571 */         new xdb.logs.LogInt(this, WingContent.this.guarantee_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  575 */             WingContent.this.guarantee_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  579 */     });
/*  580 */     this.guarantee_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  586 */     _xdb_verify_unsafe_();
/*  587 */     WingContent _o_ = null;
/*  588 */     if ((_o1_ instanceof WingContent)) { _o_ = (WingContent)_o1_;
/*  589 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  590 */       return false;
/*  591 */     if (this.cfgid != _o_.cfgid) return false;
/*  592 */     if (this.colorid != _o_.colorid) return false;
/*  593 */     if (!this.reproids.equals(_o_.reproids)) return false;
/*  594 */     if (!this.reskillids.equals(_o_.reskillids)) return false;
/*  595 */     if (!this.proids.equals(_o_.proids)) return false;
/*  596 */     if (!this.skills.equals(_o_.skills)) return false;
/*  597 */     if (!this.target_skills.equals(_o_.target_skills)) return false;
/*  598 */     if (this.guarantee_times != _o_.guarantee_times) return false;
/*  599 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  605 */     _xdb_verify_unsafe_();
/*  606 */     int _h_ = 0;
/*  607 */     _h_ += this.cfgid;
/*  608 */     _h_ += this.colorid;
/*  609 */     _h_ += this.reproids.hashCode();
/*  610 */     _h_ += this.reskillids.hashCode();
/*  611 */     _h_ += this.proids.hashCode();
/*  612 */     _h_ += this.skills.hashCode();
/*  613 */     _h_ += this.target_skills.hashCode();
/*  614 */     _h_ += this.guarantee_times;
/*  615 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  621 */     _xdb_verify_unsafe_();
/*  622 */     StringBuilder _sb_ = new StringBuilder();
/*  623 */     _sb_.append("(");
/*  624 */     _sb_.append(this.cfgid);
/*  625 */     _sb_.append(",");
/*  626 */     _sb_.append(this.colorid);
/*  627 */     _sb_.append(",");
/*  628 */     _sb_.append(this.reproids);
/*  629 */     _sb_.append(",");
/*  630 */     _sb_.append(this.reskillids);
/*  631 */     _sb_.append(",");
/*  632 */     _sb_.append(this.proids);
/*  633 */     _sb_.append(",");
/*  634 */     _sb_.append(this.skills);
/*  635 */     _sb_.append(",");
/*  636 */     _sb_.append(this.target_skills);
/*  637 */     _sb_.append(",");
/*  638 */     _sb_.append(this.guarantee_times);
/*  639 */     _sb_.append(")");
/*  640 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  646 */     ListenableBean lb = new ListenableBean();
/*  647 */     lb.add(new ListenableChanged().setVarName("cfgid"));
/*  648 */     lb.add(new ListenableChanged().setVarName("colorid"));
/*  649 */     lb.add(new ListenableChanged().setVarName("reproids"));
/*  650 */     lb.add(new ListenableChanged().setVarName("reskillids"));
/*  651 */     lb.add(new ListenableChanged().setVarName("proids"));
/*  652 */     lb.add(new ListenableChanged().setVarName("skills"));
/*  653 */     lb.add(new xdb.logs.ListenableMap().setVarName("target_skills"));
/*  654 */     lb.add(new ListenableChanged().setVarName("guarantee_times"));
/*  655 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.WingContent {
/*      */     private Const() {}
/*      */     
/*      */     WingContent nThis() {
/*  662 */       return WingContent.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  668 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingContent copy()
/*      */     {
/*  674 */       return WingContent.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingContent toData()
/*      */     {
/*  680 */       return WingContent.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.WingContent toBean()
/*      */     {
/*  685 */       return WingContent.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingContent toDataIf()
/*      */     {
/*  691 */       return WingContent.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.WingContent toBeanIf()
/*      */     {
/*  696 */       return WingContent.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCfgid()
/*      */     {
/*  703 */       WingContent.this._xdb_verify_unsafe_();
/*  704 */       return WingContent.this.cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getColorid()
/*      */     {
/*  711 */       WingContent.this._xdb_verify_unsafe_();
/*  712 */       return WingContent.this.colorid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getReproids()
/*      */     {
/*  719 */       WingContent.this._xdb_verify_unsafe_();
/*  720 */       return xdb.Consts.constList(WingContent.this.reproids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getReproidsAsData()
/*      */     {
/*  726 */       WingContent.this._xdb_verify_unsafe_();
/*      */       
/*  728 */       WingContent _o_ = WingContent.this;
/*  729 */       List<Integer> reproids = new ArrayList();
/*  730 */       reproids.addAll(_o_.reproids);
/*  731 */       return reproids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getReskillids()
/*      */     {
/*  738 */       WingContent.this._xdb_verify_unsafe_();
/*  739 */       return xdb.Consts.constList(WingContent.this.reskillids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getReskillidsAsData()
/*      */     {
/*  745 */       WingContent.this._xdb_verify_unsafe_();
/*      */       
/*  747 */       WingContent _o_ = WingContent.this;
/*  748 */       List<Integer> reskillids = new ArrayList();
/*  749 */       reskillids.addAll(_o_.reskillids);
/*  750 */       return reskillids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getProids()
/*      */     {
/*  757 */       WingContent.this._xdb_verify_unsafe_();
/*  758 */       return xdb.Consts.constList(WingContent.this.proids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getProidsAsData()
/*      */     {
/*  764 */       WingContent.this._xdb_verify_unsafe_();
/*      */       
/*  766 */       WingContent _o_ = WingContent.this;
/*  767 */       List<Integer> proids = new ArrayList();
/*  768 */       proids.addAll(_o_.proids);
/*  769 */       return proids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getSkills()
/*      */     {
/*  776 */       WingContent.this._xdb_verify_unsafe_();
/*  777 */       return xdb.Consts.constList(WingContent.this.skills);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getSkillsAsData()
/*      */     {
/*  783 */       WingContent.this._xdb_verify_unsafe_();
/*      */       
/*  785 */       WingContent _o_ = WingContent.this;
/*  786 */       List<Integer> skills = new ArrayList();
/*  787 */       skills.addAll(_o_.skills);
/*  788 */       return skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getTarget_skills()
/*      */     {
/*  795 */       WingContent.this._xdb_verify_unsafe_();
/*  796 */       return xdb.Consts.constMap(WingContent.this.target_skills);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getTarget_skillsAsData()
/*      */     {
/*  803 */       WingContent.this._xdb_verify_unsafe_();
/*      */       
/*  805 */       WingContent _o_ = WingContent.this;
/*  806 */       Map<Integer, Integer> target_skills = new HashMap();
/*  807 */       for (Map.Entry<Integer, Integer> _e_ : _o_.target_skills.entrySet())
/*  808 */         target_skills.put(_e_.getKey(), _e_.getValue());
/*  809 */       return target_skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGuarantee_times()
/*      */     {
/*  816 */       WingContent.this._xdb_verify_unsafe_();
/*  817 */       return WingContent.this.guarantee_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCfgid(int _v_)
/*      */     {
/*  824 */       WingContent.this._xdb_verify_unsafe_();
/*  825 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setColorid(int _v_)
/*      */     {
/*  832 */       WingContent.this._xdb_verify_unsafe_();
/*  833 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGuarantee_times(int _v_)
/*      */     {
/*  840 */       WingContent.this._xdb_verify_unsafe_();
/*  841 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  847 */       WingContent.this._xdb_verify_unsafe_();
/*  848 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  854 */       WingContent.this._xdb_verify_unsafe_();
/*  855 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  861 */       return WingContent.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  867 */       return WingContent.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  873 */       WingContent.this._xdb_verify_unsafe_();
/*  874 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  880 */       return WingContent.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  886 */       return WingContent.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  892 */       WingContent.this._xdb_verify_unsafe_();
/*  893 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  899 */       return WingContent.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  905 */       return WingContent.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  911 */       return WingContent.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  917 */       return WingContent.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  923 */       return WingContent.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  929 */       return WingContent.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  935 */       return WingContent.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.WingContent
/*      */   {
/*      */     private int cfgid;
/*      */     
/*      */     private int colorid;
/*      */     
/*      */     private ArrayList<Integer> reproids;
/*      */     
/*      */     private ArrayList<Integer> reskillids;
/*      */     
/*      */     private ArrayList<Integer> proids;
/*      */     
/*      */     private ArrayList<Integer> skills;
/*      */     
/*      */     private HashMap<Integer, Integer> target_skills;
/*      */     
/*      */     private int guarantee_times;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  961 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  966 */       this.reproids = new ArrayList();
/*  967 */       this.reskillids = new ArrayList();
/*  968 */       this.proids = new ArrayList();
/*  969 */       this.skills = new ArrayList();
/*  970 */       this.target_skills = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.WingContent _o1_)
/*      */     {
/*  975 */       if ((_o1_ instanceof WingContent)) { assign((WingContent)_o1_);
/*  976 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  977 */       } else if ((_o1_ instanceof WingContent.Const)) assign(((WingContent.Const)_o1_).nThis()); else {
/*  978 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(WingContent _o_) {
/*  983 */       this.cfgid = _o_.cfgid;
/*  984 */       this.colorid = _o_.colorid;
/*  985 */       this.reproids = new ArrayList();
/*  986 */       this.reproids.addAll(_o_.reproids);
/*  987 */       this.reskillids = new ArrayList();
/*  988 */       this.reskillids.addAll(_o_.reskillids);
/*  989 */       this.proids = new ArrayList();
/*  990 */       this.proids.addAll(_o_.proids);
/*  991 */       this.skills = new ArrayList();
/*  992 */       this.skills.addAll(_o_.skills);
/*  993 */       this.target_skills = new HashMap();
/*  994 */       for (Map.Entry<Integer, Integer> _e_ : _o_.target_skills.entrySet())
/*  995 */         this.target_skills.put(_e_.getKey(), _e_.getValue());
/*  996 */       this.guarantee_times = _o_.guarantee_times;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1001 */       this.cfgid = _o_.cfgid;
/* 1002 */       this.colorid = _o_.colorid;
/* 1003 */       this.reproids = new ArrayList();
/* 1004 */       this.reproids.addAll(_o_.reproids);
/* 1005 */       this.reskillids = new ArrayList();
/* 1006 */       this.reskillids.addAll(_o_.reskillids);
/* 1007 */       this.proids = new ArrayList();
/* 1008 */       this.proids.addAll(_o_.proids);
/* 1009 */       this.skills = new ArrayList();
/* 1010 */       this.skills.addAll(_o_.skills);
/* 1011 */       this.target_skills = new HashMap();
/* 1012 */       for (Map.Entry<Integer, Integer> _e_ : _o_.target_skills.entrySet())
/* 1013 */         this.target_skills.put(_e_.getKey(), _e_.getValue());
/* 1014 */       this.guarantee_times = _o_.guarantee_times;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1020 */       _os_.marshal(this.cfgid);
/* 1021 */       _os_.marshal(this.colorid);
/* 1022 */       _os_.compact_uint32(this.reproids.size());
/* 1023 */       for (Integer _v_ : this.reproids)
/*      */       {
/* 1025 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1027 */       _os_.compact_uint32(this.reskillids.size());
/* 1028 */       for (Integer _v_ : this.reskillids)
/*      */       {
/* 1030 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1032 */       _os_.compact_uint32(this.proids.size());
/* 1033 */       for (Integer _v_ : this.proids)
/*      */       {
/* 1035 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1037 */       _os_.compact_uint32(this.skills.size());
/* 1038 */       for (Integer _v_ : this.skills)
/*      */       {
/* 1040 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1042 */       _os_.compact_uint32(this.target_skills.size());
/* 1043 */       for (Map.Entry<Integer, Integer> _e_ : this.target_skills.entrySet())
/*      */       {
/* 1045 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1046 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1048 */       _os_.marshal(this.guarantee_times);
/* 1049 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1055 */       this.cfgid = _os_.unmarshal_int();
/* 1056 */       this.colorid = _os_.unmarshal_int();
/* 1057 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1059 */         int _v_ = 0;
/* 1060 */         _v_ = _os_.unmarshal_int();
/* 1061 */         this.reproids.add(Integer.valueOf(_v_));
/*      */       }
/* 1063 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1065 */         int _v_ = 0;
/* 1066 */         _v_ = _os_.unmarshal_int();
/* 1067 */         this.reskillids.add(Integer.valueOf(_v_));
/*      */       }
/* 1069 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1071 */         int _v_ = 0;
/* 1072 */         _v_ = _os_.unmarshal_int();
/* 1073 */         this.proids.add(Integer.valueOf(_v_));
/*      */       }
/* 1075 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1077 */         int _v_ = 0;
/* 1078 */         _v_ = _os_.unmarshal_int();
/* 1079 */         this.skills.add(Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1082 */       int size = _os_.uncompact_uint32();
/* 1083 */       if (size >= 12)
/*      */       {
/* 1085 */         this.target_skills = new HashMap(size * 2);
/*      */       }
/* 1087 */       for (; size > 0; size--)
/*      */       {
/* 1089 */         int _k_ = 0;
/* 1090 */         _k_ = _os_.unmarshal_int();
/* 1091 */         int _v_ = 0;
/* 1092 */         _v_ = _os_.unmarshal_int();
/* 1093 */         this.target_skills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1096 */       this.guarantee_times = _os_.unmarshal_int();
/* 1097 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1103 */       int _size_ = 0;
/* 1104 */       _size_ += CodedOutputStream.computeInt32Size(1, this.cfgid);
/* 1105 */       _size_ += CodedOutputStream.computeInt32Size(2, this.colorid);
/* 1106 */       for (Integer _v_ : this.reproids)
/*      */       {
/* 1108 */         _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*      */       }
/* 1110 */       for (Integer _v_ : this.reskillids)
/*      */       {
/* 1112 */         _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */       }
/* 1114 */       for (Integer _v_ : this.proids)
/*      */       {
/* 1116 */         _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */       }
/* 1118 */       for (Integer _v_ : this.skills)
/*      */       {
/* 1120 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/* 1122 */       for (Map.Entry<Integer, Integer> _e_ : this.target_skills.entrySet())
/*      */       {
/* 1124 */         _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getKey()).intValue());
/* 1125 */         _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1127 */       _size_ += CodedOutputStream.computeInt32Size(8, this.guarantee_times);
/* 1128 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1136 */         _output_.writeInt32(1, this.cfgid);
/* 1137 */         _output_.writeInt32(2, this.colorid);
/* 1138 */         for (Integer _v_ : this.reproids)
/*      */         {
/* 1140 */           _output_.writeInt32(3, _v_.intValue());
/*      */         }
/* 1142 */         for (Integer _v_ : this.reskillids)
/*      */         {
/* 1144 */           _output_.writeInt32(4, _v_.intValue());
/*      */         }
/* 1146 */         for (Integer _v_ : this.proids)
/*      */         {
/* 1148 */           _output_.writeInt32(5, _v_.intValue());
/*      */         }
/* 1150 */         for (Integer _v_ : this.skills)
/*      */         {
/* 1152 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/* 1154 */         for (Map.Entry<Integer, Integer> _e_ : this.target_skills.entrySet())
/*      */         {
/* 1156 */           _output_.writeInt32(7, ((Integer)_e_.getKey()).intValue());
/* 1157 */           _output_.writeInt32(7, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1159 */         _output_.writeInt32(8, this.guarantee_times);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1163 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1165 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1173 */         boolean done = false;
/* 1174 */         while (!done)
/*      */         {
/* 1176 */           int tag = _input_.readTag();
/* 1177 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1181 */             done = true;
/* 1182 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1186 */             this.cfgid = _input_.readInt32();
/* 1187 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1191 */             this.colorid = _input_.readInt32();
/* 1192 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1196 */             int _v_ = 0;
/* 1197 */             _v_ = _input_.readInt32();
/* 1198 */             this.reproids.add(Integer.valueOf(_v_));
/* 1199 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1203 */             int _v_ = 0;
/* 1204 */             _v_ = _input_.readInt32();
/* 1205 */             this.reskillids.add(Integer.valueOf(_v_));
/* 1206 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1210 */             int _v_ = 0;
/* 1211 */             _v_ = _input_.readInt32();
/* 1212 */             this.proids.add(Integer.valueOf(_v_));
/* 1213 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1217 */             int _v_ = 0;
/* 1218 */             _v_ = _input_.readInt32();
/* 1219 */             this.skills.add(Integer.valueOf(_v_));
/* 1220 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1224 */             int _k_ = 0;
/* 1225 */             _k_ = _input_.readInt32();
/* 1226 */             int readTag = _input_.readTag();
/* 1227 */             if (56 != readTag)
/*      */             {
/* 1229 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1231 */             int _v_ = 0;
/* 1232 */             _v_ = _input_.readInt32();
/* 1233 */             this.target_skills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1234 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1238 */             this.guarantee_times = _input_.readInt32();
/* 1239 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1243 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1245 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1254 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1258 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1260 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingContent copy()
/*      */     {
/* 1266 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingContent toData()
/*      */     {
/* 1272 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.WingContent toBean()
/*      */     {
/* 1277 */       return new WingContent(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingContent toDataIf()
/*      */     {
/* 1283 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.WingContent toBeanIf()
/*      */     {
/* 1288 */       return new WingContent(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1294 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1298 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1302 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1306 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1310 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1314 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1318 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCfgid()
/*      */     {
/* 1325 */       return this.cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getColorid()
/*      */     {
/* 1332 */       return this.colorid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getReproids()
/*      */     {
/* 1339 */       return this.reproids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getReproidsAsData()
/*      */     {
/* 1346 */       return this.reproids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getReskillids()
/*      */     {
/* 1353 */       return this.reskillids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getReskillidsAsData()
/*      */     {
/* 1360 */       return this.reskillids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getProids()
/*      */     {
/* 1367 */       return this.proids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getProidsAsData()
/*      */     {
/* 1374 */       return this.proids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getSkills()
/*      */     {
/* 1381 */       return this.skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getSkillsAsData()
/*      */     {
/* 1388 */       return this.skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getTarget_skills()
/*      */     {
/* 1395 */       return this.target_skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getTarget_skillsAsData()
/*      */     {
/* 1402 */       return this.target_skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGuarantee_times()
/*      */     {
/* 1409 */       return this.guarantee_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCfgid(int _v_)
/*      */     {
/* 1416 */       this.cfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setColorid(int _v_)
/*      */     {
/* 1423 */       this.colorid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGuarantee_times(int _v_)
/*      */     {
/* 1430 */       this.guarantee_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1436 */       if (!(_o1_ instanceof Data)) return false;
/* 1437 */       Data _o_ = (Data)_o1_;
/* 1438 */       if (this.cfgid != _o_.cfgid) return false;
/* 1439 */       if (this.colorid != _o_.colorid) return false;
/* 1440 */       if (!this.reproids.equals(_o_.reproids)) return false;
/* 1441 */       if (!this.reskillids.equals(_o_.reskillids)) return false;
/* 1442 */       if (!this.proids.equals(_o_.proids)) return false;
/* 1443 */       if (!this.skills.equals(_o_.skills)) return false;
/* 1444 */       if (!this.target_skills.equals(_o_.target_skills)) return false;
/* 1445 */       if (this.guarantee_times != _o_.guarantee_times) return false;
/* 1446 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1452 */       int _h_ = 0;
/* 1453 */       _h_ += this.cfgid;
/* 1454 */       _h_ += this.colorid;
/* 1455 */       _h_ += this.reproids.hashCode();
/* 1456 */       _h_ += this.reskillids.hashCode();
/* 1457 */       _h_ += this.proids.hashCode();
/* 1458 */       _h_ += this.skills.hashCode();
/* 1459 */       _h_ += this.target_skills.hashCode();
/* 1460 */       _h_ += this.guarantee_times;
/* 1461 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1467 */       StringBuilder _sb_ = new StringBuilder();
/* 1468 */       _sb_.append("(");
/* 1469 */       _sb_.append(this.cfgid);
/* 1470 */       _sb_.append(",");
/* 1471 */       _sb_.append(this.colorid);
/* 1472 */       _sb_.append(",");
/* 1473 */       _sb_.append(this.reproids);
/* 1474 */       _sb_.append(",");
/* 1475 */       _sb_.append(this.reskillids);
/* 1476 */       _sb_.append(",");
/* 1477 */       _sb_.append(this.proids);
/* 1478 */       _sb_.append(",");
/* 1479 */       _sb_.append(this.skills);
/* 1480 */       _sb_.append(",");
/* 1481 */       _sb_.append(this.target_skills);
/* 1482 */       _sb_.append(",");
/* 1483 */       _sb_.append(this.guarantee_times);
/* 1484 */       _sb_.append(")");
/* 1485 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\WingContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */